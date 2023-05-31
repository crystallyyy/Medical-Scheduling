package com.techelevator.dao;

import com.techelevator.model.Patient;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.List;

public class JdbcPatientDao implements PatientDAO{

    private final JdbcTemplate jdbcTemplate;

    public JdbcPatientDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Patient getPatientById(int patientId){
        Patient patient = null;
        String sql = "SELECT * FROM patient WHERE patient_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, patientId);
        if(result.next()){
            patient = mapRowToPatient(result);
        }
        return patient;
    }

    @Override
    public List<Patient> getAllPatients() {
        return null;
    }

    @Override
    public Patient addPatient(Patient patient) {

        String sql = "INSERT INTO patient (user_id, first_name, last_name, date_of_birth, address, phone_number) " +
                "VALUES (?, ?, ?, ?, ?, ?) RETURNING patient_id;";
        int newId = jdbcTemplate.queryForObject(sql, int.class, patient.getUserId(), patient.getFirstName(), patient.getLastName(),
                patient.getDateOfBirth(), patient.getAddress(), patient.getPhoneNumber());
        return getPatientById(newId);
    }

    private Patient mapRowToPatient(SqlRowSet row){
        Patient patient = new Patient(
                row.getInt("patient_id"),
                row.getInt("user_id"),
                row.getString("first_name"),
                row.getString("last_name"),
                row.getDate("date_of_birth").toLocalDate(),
                row.getString("address"),
                row.getInt("phone_number")
        );

        return patient;
    }
}
