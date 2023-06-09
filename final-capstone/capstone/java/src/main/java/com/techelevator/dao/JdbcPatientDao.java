package com.techelevator.dao;

import com.techelevator.model.Doctor;
import com.techelevator.model.Patient;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
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
    public boolean updatePatient(Patient patient) {
        String sql = "UPDATE patient SET first_name = ?, last_name = ?, date_of_birth = ?, address = ?, phone_number = ? " +
                "WHERE patient_id = ?;";
        int numRows = jdbcTemplate.update(sql, patient.getFirstName(), patient.getLastName(), patient.getDateOfBirth(),
                patient.getAddress(), patient.getPhoneNumber(), patient.getPatientId());

        return numRows > 0;
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
        Patient patient = new Patient();
        patient.setUserId(row.getInt("user_id"));
        patient.setPatientId(row.getInt("patient_id"));
        patient.setFirstName(row.getString("first_name"));
        patient.setLastName(row.getString("last_name"));
        patient.setDateOfBirth(row.getDate("date_of_birth").toLocalDate());
        patient.setAddress(row.getString("address"));
        patient.setPhoneNumber(row.getString("phone_number"));
        return patient;
    }
    @Override
    public Patient getPatientByUserId(int userID) {
        Patient patient = null;
        String sql = "SELECT * FROM patient WHERE user_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql,userID);
        if(result.next()){
            patient = mapRowToPatient(result);
        }
        return patient;
    }
}
