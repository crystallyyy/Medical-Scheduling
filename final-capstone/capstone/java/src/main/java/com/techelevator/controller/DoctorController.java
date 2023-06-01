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
@PreAuthorize("permitAll()")
public class DoctorController {

    @Autowired
     DoctorDAO doctorDAO;

    @GetMapping(path = "/providers")
    public List<Doctor> listProviders(){

        return doctorDAO.getAllDoctors();

    }

    @PostMapping(path = "/providers")
    public Doctor newDoctor(@Valid @RequestBody Doctor doctor){

        return doctorDAO.addDoctor(doctor);
    }

    @GetMapping(path = "/providers/{doctorId}")
    public Doctor getDoctorById(@PathVariable int doctorId){

        return doctorDAO.getDoctorById(doctorId);
    }

    //necessary?
    @DeleteMapping(path = "/providers/{doctorId}")
    public void deleteDoctor(@PathVariable int doctorId){

    }

    @PutMapping(path = "providers/{doctorId}")
    public Doctor updateDoctorInfo(@PathVariable int doctorId,  @Valid @RequestBody Doctor doctorToUpdate){

        return doctorDAO.updateDoctor(doctorToUpdate);
    }

    @GetMapping(path = "/providers/offices/{officeId}")
    public List<Doctor> getDoctorsByOffice(@PathVariable int officeId){

        return doctorDAO.getDoctorsByOffice(officeId);
    }
}
