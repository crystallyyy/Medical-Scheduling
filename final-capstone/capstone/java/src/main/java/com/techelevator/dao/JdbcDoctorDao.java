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
    public Doctor addDoctor(Doctor doctor) {

        return null;
    }

    @Override
    public Doctor updateDoctor(int doctorId, Doctor doctor) {
        return null;
    }

    @Override
    public List<Doctor> getDoctorsByOffice(int officeId) {
        return null;
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
