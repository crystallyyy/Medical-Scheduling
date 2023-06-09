package com.techelevator.controller;

import com.techelevator.dao.AppointmentDao;
import com.techelevator.dao.AvailabilityDAO;
import com.techelevator.model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin
public class AppointmentController {

    @Autowired
    AppointmentDao appointmentDao;

    @PostMapping(path = "/appointment")
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    public Appointment addAppointment(@Valid @RequestBody Appointment appointment){
        Appointment newAppointment = null;
        try{
            newAppointment = appointmentDao.newAppt(appointment);
        } catch (DuplicateKeyException e){
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
        return appointmentDao.newAppt(appointment);
    }
//    @GetMapping(path = "/appointment/{doctorId}")
//    @CrossOrigin
//    public List<Appointment> getApptsByDocDate(@PathVariable int doctorId, LocalDate apptDate){
//        return appointmentDao.getAppointmentsByDocDate(doctorId, apptDate);
//    }

    @GetMapping(path = "/appointments/{patientId}")
    public List<Appointment> getAppointmentsForPatient(@PathVariable int patientId){
        return appointmentDao.getAppointmentsByPatient(patientId);
    }

    @GetMapping(path = "/appointmentsByDoc/{doctorId}")
    public List<Appointment> getAppointmentsForDoctor(@PathVariable int doctorId){
        return appointmentDao.getAppointmentsByDoctor(doctorId);
    }
}
