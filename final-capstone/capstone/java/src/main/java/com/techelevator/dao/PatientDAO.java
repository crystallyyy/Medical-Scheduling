package com.techelevator.dao;

import com.techelevator.model.Patient;

import java.util.List;

public interface PatientDAO {

    public List<Patient> getAllPatients();
    Patient addPatient(Patient patient);
    Patient getPatientById(int patientId);
    boolean updatePatient(Patient patient);
    Patient getPatientByUserId(int userID);
}
