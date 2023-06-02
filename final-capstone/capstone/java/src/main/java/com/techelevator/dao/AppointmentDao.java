package com.techelevator.dao;

import com.techelevator.model.Appointment;

public interface AppointmentDao {

    Appointment newAppt(Appointment appointment);
    void cancelAppt(int apptId);
}
