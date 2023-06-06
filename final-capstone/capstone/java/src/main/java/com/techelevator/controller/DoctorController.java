package com.techelevator.controller;

import com.techelevator.dao.AvailabilityDAO;
import com.techelevator.dao.DoctorDAO;
import com.techelevator.model.Doctor;
import com.techelevator.model.DoctorAvailability;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
//@PreAuthorize("permitAll()")
@CrossOrigin
public class DoctorController {

    @Autowired
     DoctorDAO doctorDAO;
    @Autowired
    AvailabilityDAO availabilityDAO;

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

    @GetMapping(path = "/pid/{userId}")
    public Doctor getDoctorByUserId(@PathVariable int userId){
         return doctorDAO.getDoctorByUserId(userId);
    }

    //necessary?
    @DeleteMapping(path = "/providers/{doctorId}")
    public void deleteDoctor(@PathVariable int doctorId){

    }

    @CrossOrigin
    @PutMapping(path = "pid/update/{doctorId}")
    @ResponseStatus(HttpStatus.OK)
    public boolean updateDoctorInfo(@PathVariable int doctorId,  @Valid @RequestBody Doctor doctorToUpdate){
        return doctorDAO.updateDoctor(doctorToUpdate);
    }

    @GetMapping(path = "/providers/offices/{officeId}")
    public List<Doctor> getDoctorsByOffice(@PathVariable int officeId){

        return doctorDAO.getDoctorsByOffice(officeId);
    }

    @GetMapping(path = "/availability/{doctorId}")
    public List<DoctorAvailability> availabilityByDoctor(@PathVariable int doctorId){
        return availabilityDAO.getAvailabilityById(doctorId);
    }

    @PutMapping(path = "/availability/{doctorId}")
    public boolean updateDoctorAvailability(@PathVariable int doctorId,  @Valid @RequestBody DoctorAvailability doctorAvailability){
        return availabilityDAO.updateAvailability(doctorAvailability);
    }

    @GetMapping(path = "/availabilities")
    public List<DoctorAvailability> listAllAvailabilities(){
        return availabilityDAO.listAvailabilities();
    }

    @GetMapping(path = "/providersIds/{officeId}")
    public List<Integer> getDoctorIdsByOfficeId(@PathVariable int officeId){
        return doctorDAO.getDoctorIdsByOfficeId(officeId);
    }

    @PostMapping(path = "/availability")
    public boolean createAvailability(@Valid @RequestBody DoctorAvailability availability){
        return availabilityDAO.createAvailability(availability);
    }
}
