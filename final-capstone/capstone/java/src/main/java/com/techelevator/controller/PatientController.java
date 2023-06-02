package com.techelevator.controller;

import com.techelevator.dao.JdbcPatientDao;
import com.techelevator.dao.PatientDAO;
import com.techelevator.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@PreAuthorize("isAuthenticated()")
public class PatientController {
    @Autowired
    JdbcPatientDao patientDAO;

    @PostMapping(path = "/patients")
    public Patient newPatient(@Valid @RequestBody Patient patient){
        return patientDAO.addPatient(patient);
    }

    //TODO: GET PATIENT BY ID
}
