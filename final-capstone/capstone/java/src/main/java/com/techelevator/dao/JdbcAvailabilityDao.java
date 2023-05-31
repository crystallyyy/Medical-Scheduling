package com.techelevator.dao;

import com.techelevator.model.Doctor;
import com.techelevator.model.DoctorAvailability;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcAvailabilityDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcAvailabilityDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<DoctorAvailability> getAvailabilityById(int doctorId){
        List<DoctorAvailability> doctorsAvailability = new ArrayList<>();
        String sql = "SELECT * FROM doctor_availability WHERE doctor_id = ?"; // AS d JOIN doctor_availability AS da ON d.doctor_id = da.doctor_id"
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, doctorId);
        while (results.next()){
            DoctorAvailability availability = mapRowToAvailability(results);
            doctorsAvailability.add(availability);
        }
        return doctorsAvailability;
    }

    private DoctorAvailability mapRowToAvailability(SqlRowSet results) {
        DoctorAvailability doctorAvailability = new DoctorAvailability();
        doctorAvailability.setDoctorId(results.getInt("doctor_id"));
        doctorAvailability.setDayOdWeek(results.getString("day_of_week"));
        doctorAvailability.setStartTime(results.getTime("start_time").toLocalTime());
        doctorAvailability.setStartTime(results.getTime("end_time").toLocalTime());
        return doctorAvailability;
    }
}
