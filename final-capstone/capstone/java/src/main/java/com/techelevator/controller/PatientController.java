package com.techelevator.controller;

import com.techelevator.dao.JdbcPatientDao;
import com.techelevator.dao.PatientDAO;
import com.techelevator.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
//@PreAuthorize("isAuthenticated()")
@CrossOrigin
public class PatientController {
    @Autowired
    JdbcPatientDao patientDAO;

    @PostMapping(path = "/patients")
    public Patient newPatient(@Valid @RequestBody Patient patient){
        return patientDAO.addPatient(patient);
    }

    @GetMapping(path = "/patient/{patientId}")
    public Patient getPatientById(@PathVariable int patientId){
        return patientDAO.getPatientById(patientId);
    }
    @GetMapping(path = "/users/patients/{userID}")
    public Patient getPatientByUserId(@PathVariable int userID){
        return patientDAO.getPatientByUserId(userID);
    }

    @PutMapping(path = "/patient/update/{patientId}")
    @ResponseStatus(HttpStatus.OK)
    public boolean updatePatient(@PathVariable int patientId, @Valid @RequestBody Patient patient){
        return patientDAO.updatePatient(patient);
    }
}
