package com.techelevator.model;

import java.time.LocalTime;

public class OfficeHours {
    private int ohId;
    private int officeId;
    private String dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    public OfficeHours() {
    }

    public OfficeHours(int ohId, int officeId, String dayOfWeek, LocalTime startTime, LocalTime endTime) {
        this.ohId = ohId;
        this.officeId = officeId;
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getOhId() {
        return ohId;
    }

    public void setOhId(int ohId) {
        this.ohId = ohId;
    }

    public int getOfficeId() {
        return officeId;
    }

    public void setOfficeId(int officeId) {
        this.officeId = officeId;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
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
