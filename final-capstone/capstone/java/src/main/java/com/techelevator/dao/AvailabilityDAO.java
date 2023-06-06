package com.techelevator.dao;

import com.techelevator.model.DoctorAvailability;

import java.util.List;

public interface AvailabilityDAO {

    List<DoctorAvailability> getAvailabilityById(int doctorId);

    boolean updateAvailability(DoctorAvailability doctorAvailability);

    List<DoctorAvailability> listAvailabilities();

    boolean createAvailability(DoctorAvailability availability);
}