package com.techelevator.dao;

import com.techelevator.model.Doctor;
import com.techelevator.model.DoctorAvailability;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcAvailabilityDao implements AvailabilityDAO{

    private final JdbcTemplate jdbcTemplate;

    public JdbcAvailabilityDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<DoctorAvailability> getAvailabilityById(int doctorId){
        List<DoctorAvailability> doctorsAvailability = new ArrayList<>();
        String sql = "SELECT * FROM doctor_availability WHERE doctor_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, doctorId);
        while (results.next()){
            DoctorAvailability availability = mapRowToAvailability(results);
            doctorsAvailability.add(availability);
        }
        return doctorsAvailability;
    }

    public boolean updateAvailability(DoctorAvailability doctorAvailability){
        String sql = "UPDATE doctor_availability SET start_time = ?, end_time = ? " +
                "WHERE doctor_id = ? AND day_of_week = ?";
        int numRows = jdbcTemplate.update(sql, doctorAvailability.getStartTime(), doctorAvailability.getEndTime(),
                doctorAvailability.getDoctorId(), doctorAvailability.getDayOfWeek());
        boolean isUpdated = numRows > 0;
        return isUpdated;
    }

    public List<DoctorAvailability> listAvailabilities(){
        List<DoctorAvailability> availabilities = new ArrayList<>();
        String sql = "SELECT * FROM doctor_availability";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()){
            DoctorAvailability availability = mapRowToAvailability(results);
            availabilities.add(availability);
        }
        return availabilities;
    }

    public boolean createAvailability(DoctorAvailability availability){
        DoctorAvailability oneAvailability = null;
        String sql = "INSERT INTO doctor_availability (doctor_id, day_of_week, start_time, end_time) " +
                "VALUES (?, ?, ?, ?) RETURNING doctor_id;";
        int doctorId = jdbcTemplate.queryForObject(sql, int.class, availability.getDoctorId(), availability.getDayOfWeek(), availability.getStartTime(), availability.getEndTime());
        if(doctorId > 0){
            return true;
        }
        return false;
    }

    private DoctorAvailability mapRowToAvailability(SqlRowSet results) {
        DoctorAvailability doctorAvailability = new DoctorAvailability();
        doctorAvailability.setDoctorId(results.getInt("doctor_id"));
        doctorAvailability.setDayOfWeek(results.getString("day_of_week"));
        doctorAvailability.setStartTime(results.getTime("start_time").toLocalTime());
        doctorAvailability.setEndTime(results.getTime("end_time").toLocalTime());
        return doctorAvailability;
    }
}
