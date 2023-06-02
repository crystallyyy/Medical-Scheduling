package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class Doctor {
    private int doctorId;
    private int userId;
    private String firstName;
    private String lastName;
    private int timeSlotDefault;
    private String email;
    @JsonIgnore
    private List<DoctorAvailability> doctorAvailability;

    public Doctor() {
    }

    public Doctor(int doctorId, int userId, String firstName, String lastName, int timeSlotDefault, String email) {
        this.doctorId = doctorId;
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.timeSlotDefault = timeSlotDefault;
        this.email = email;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getTimeSlotDefault() {
        return timeSlotDefault;
    }

    public void setTimeSlotDefault(int timeSlotDefault) {
        this.timeSlotDefault = timeSlotDefault;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDoctorAvailability(List<DoctorAvailability> doctorAvailability){
        this.doctorAvailability = doctorAvailability;
    }
}
