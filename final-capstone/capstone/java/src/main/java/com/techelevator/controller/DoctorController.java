package com.techelevator.controller;

import com.techelevator.dao.DoctorDAO;
import com.techelevator.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@PreAuthorize("isAuthenticated()")
public class DoctorController {

    @Autowired
     DoctorDAO doctorDAO;

    @GetMapping(path = "/providers")
    public List<Doctor> listProviders(){
        List<Doctor> allProviders = new ArrayList<>();

        return allProviders;
    }

    @PostMapping(path = "/providers")
    public Doctor newDoctor(@Valid @RequestBody Doctor doctor){

        return doctor;
    }

    @GetMapping(path = "/providers/{doctorId}")
    public Doctor getDoctorById(@PathVariable int doctorId){
        Doctor doctor = null;

        return doctor;
    }

    //necessary?
    @DeleteMapping(path = "/providers/{doctorId}")
    public void deleteDoctor(@PathVariable int doctorId){

    }

    @PutMapping(path = "providers/{doctorId}")
    public Doctor updateDoctorInfo(@PathVariable int doctorId,  @Valid @RequestBody Doctor doctorToUpdate){
        Doctor doctor = null;

        return doctor;
    }

    @GetMapping(path = "/providers/offices/{officeId}")
    public List<Doctor> getDoctorsByOffice(@PathVariable int officeId){
        List<Doctor> doctorsByOffice = new ArrayList<>();

        return doctorsByOffice;
    }
}
