package com.techelevator.model;

public class Office {
    private int officeId;
    private String officeName;
    private String address;
    private String phoneNumber;

    public Office() {
    }

    public Office(int officeId, String officeName, String address, String phoneNumber) {
        this.officeId = officeId;
        this.officeName = officeName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public int getOfficeId() {
        return officeId;
    }

    public void setOfficeId(int officeId) {
        this.officeId = officeId;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
