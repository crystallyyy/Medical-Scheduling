package com.techelevator.controller;

import com.techelevator.dao.AppointmentDao;
import com.techelevator.dao.AvailabilityDAO;
import com.techelevator.model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@CrossOrigin
public class AppointmentController {

    @Autowired
    AppointmentDao appointmentDao;

    @PostMapping(path = "/appointment")
    public Appointment addAppointment(@Valid @RequestBody Appointment appointment){
        return appointmentDao.newAppt(appointment);
    }

}
