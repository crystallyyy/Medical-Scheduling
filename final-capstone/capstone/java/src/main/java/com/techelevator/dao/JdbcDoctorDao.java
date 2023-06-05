package com.techelevator.dao;

import com.techelevator.model.Doctor;
import com.techelevator.model.DoctorAvailability;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcDoctorDao implements DoctorDAO{

    private final JdbcTemplate jdbcTemplate;
    @Autowired
    private JdbcAvailabilityDao jdbcAvailabilityDao;
    public JdbcDoctorDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Doctor> getAllDoctors() {
        List<Doctor> allDoctors = new ArrayList<>();
        String sql = "SELECT * FROM doctor"; // AS d JOIN doctor_availability AS da ON d.doctor_id = da.doctor_id"
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()){
            Doctor doctor = mapRowToDoctor(results);
            allDoctors.add(doctor);
        }
        allDoctors.forEach(doctor -> {
           int id = doctor.getDoctorId();
           List<DoctorAvailability> availabilities = jdbcAvailabilityDao.getAvailabilityById(id);
           doctor.setDoctorAvailability(availabilities);
        });

        return allDoctors;
    }

    @Override
    public Doctor getDoctorById(int doctorId) {
        Doctor doctor = null;
        String sql = "SELECT * FROM doctor WHERE doctor_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql,doctorId);
        if(result.next()){
            doctor = mapRowToDoctor(result);
        }
        return doctor;
    }
    @Override
    public Doctor getDoctorByUserId(int userId) {
        Doctor doctor = null;
        String sql = "SELECT * FROM doctor WHERE user_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql,userId);
        if(result.next()){
            doctor = mapRowToDoctor(result);
        }
        return doctor;
    }
    @Override
    public Doctor addDoctor(Doctor doctor) {

        String sql = "INSERT INTO doctor (user_id, first_name, last_name, time_slot_default, email) " +
                "VALUES (?, ?, ?, ?, ?) RETURNING doctor_id";
        int newId = jdbcTemplate.queryForObject(sql, int.class, doctor.getUserId(), doctor.getFirstName(), doctor.getLastName(),
                doctor.getTimeSlotDefault(), doctor.getEmail());

        return getDoctorById(newId);
    }

    @Override
    public boolean updateDoctor(Doctor doctor) {
        String sql = "UPDATE doctor SET first_name = ?, last_name = ?, time_slot_default = ?, email = ? " +
                "WHERE doctor_id = ?";
        int numRows = jdbcTemplate.update(sql, doctor.getFirstName(), doctor.getLastName(),
                doctor.getTimeSlotDefault(), doctor.getEmail(), doctor.getDoctorId());
        boolean isUpdated = numRows > 0;
        return isUpdated;
    }

    @Override
    public List<Doctor> getDoctorsByOffice(int officeId) {
        List<Doctor> doctorsByOffice = new ArrayList<>();
        String sql = "SELECT * FROM doctor AS d " +
                "JOIN doctor_office AS d_o ON d.doctor_id = d_o.doctor_id " +
                "JOIN office AS o ON d_o.office_id = o.office_id " +
                "WHERE o.office_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, officeId);

        while (results.next()){
            Doctor doctor = mapRowToDoctor(results);
            doctorsByOffice.add(doctor);
        }
        return doctorsByOffice;
    }

    public List<Integer> getDoctorIdsByOfficeId(int officeId) {
        List<Integer> doctorIds = new ArrayList<>();
        String sql = "SELECT doctor_id FROM doctor_office WHERE office_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, officeId);
        while (results.next()){
            Integer doctorId = results.getInt("doctor_id");
            doctorIds.add(doctorId);
        }

        return doctorIds;
    }

    private Doctor mapRowToDoctor(SqlRowSet row){
        Doctor doctor = new Doctor(
                row.getInt("doctor_id"),
                row.getInt("user_id"),
                row.getString("first_name"),
                row.getString("last_name"),
                row.getInt("time_slot_default"),
                row.getString("email")
                );
        return doctor;
    }

}
