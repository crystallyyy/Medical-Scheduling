package com.techelevator.controller;

import com.techelevator.dao.AppointmentDao;
import com.techelevator.dao.AvailabilityDAO;
import com.techelevator.model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    @ResponseStatus(HttpStatus.CREATED)
    public Appointment addAppointment(@Valid @RequestBody Appointment appointment){
        return appointmentDao.newAppt(appointment);
    }
    @GetMapping(path = "/appointment/{doctorId}")
    @CrossOrigin
    public List<Appointment> getApptsByDocDate(@PathVariable int doctorId, LocalDate apptDate){
        return appointmentDao.getAppointmentsByDocDate(doctorId, apptDate);
    }

    @GetMapping(path = "/appointments/{patientId}")
    public List<Appointment> getAppointmentsForPatient(@PathVariable int patientId){
        return appointmentDao.getAppointmentsByPatient(patientId);
    }
}
