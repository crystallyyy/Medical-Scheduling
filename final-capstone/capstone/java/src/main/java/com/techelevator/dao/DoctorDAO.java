package com.techelevator.dao;

import com.techelevator.model.Doctor;

import javax.print.Doc;
import java.util.List;

public interface DoctorDAO {

    List<Doctor> getAllDoctors();
    Doctor getDoctorById(int id);
    Doctor addDoctor(Doctor doctor);
    boolean updateDoctor(Doctor doctor);
    List<Doctor> getDoctorsByOffice(int id);
    public Doctor getDoctorByUserId(int userId);
    List<Integer> getDoctorIdsByOfficeId(int officeId);
}
