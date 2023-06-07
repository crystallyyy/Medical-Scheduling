package com.techelevator.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {

    private int appointmentId;
    private int doctorId;
    private LocalDate apptDate;
    private LocalTime startTime;
    private int duration;
    private int patientId;
    private int officeId;

    public Appointment() {
    }

    public Appointment(int appointmentId, int doctorId, LocalDate apptDate, LocalTime startTime, int duration, int patientId, int officeId) {
        this.appointmentId = appointmentId;
        this.doctorId = doctorId;
        this.apptDate = apptDate;
        this.startTime = startTime;
        this.duration = duration;
        this.patientId = patientId;
        this.officeId = officeId;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public LocalDate getApptDate() {
        return apptDate;
    }

    public void setApptDate(LocalDate apptDate) {
        this.apptDate = apptDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getOfficeId() {
        return officeId;
    }

    public void setOfficeId(int officeId) {
        this.officeId = officeId;
    }
}
