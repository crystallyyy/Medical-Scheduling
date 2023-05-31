package com.techelevator.dao;

import com.techelevator.model.Doctor;

import javax.print.Doc;
import java.util.List;

public interface DoctorDAO {

    List<Doctor> getAllDoctors();
    Doctor getDoctorById(int id);
    Doctor addDoctor(Doctor doctor);
    Doctor updateDoctor(Doctor doctor);
    List<Doctor> getDoctorsByOffice(int id);
}
