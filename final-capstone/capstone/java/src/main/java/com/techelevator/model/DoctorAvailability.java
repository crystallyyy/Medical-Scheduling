package com.techelevator.model;

import java.time.LocalTime;

public class DoctorAvailability {
    private int availabilityId;
    private int doctorId;
    private String dayOdWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    public DoctorAvailability() {
    }

    public DoctorAvailability(int availabilityId, int doctorId, String dayOdWeek, LocalTime startTime, LocalTime endTime) {
        this.availabilityId = availabilityId;
        this.doctorId = doctorId;
        this.dayOdWeek = dayOdWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getAvailabilityId() {
        return availabilityId;
    }

    public void setAvailabilityId(int availabilityId) {
        this.availabilityId = availabilityId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getDayOdWeek() {
        return dayOdWeek;
    }

    public void setDayOdWeek(String dayOdWeek) {
        this.dayOdWeek = dayOdWeek;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }
}
