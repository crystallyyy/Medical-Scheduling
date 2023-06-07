package com.techelevator.dao;

import com.techelevator.model.Appointment;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentDao {

    Appointment newAppt(Appointment appointment);
    void cancelAppt(int apptId);
    List<Appointment> getAppointmentsByDoctor(int doctorId);
    List<Appointment> getAppointmentsByPatient(int patientId);
    List<Appointment> getAppointmentsByDocDate(int doctorId, LocalDate apptDate);
}
