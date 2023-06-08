package com.techelevator.controller;

import com.techelevator.dao.OfficeDAO;
import com.techelevator.model.Office;
import com.techelevator.model.OfficeHours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
//@PreAuthorize("isAuthenticated()")
@CrossOrigin
public class OfficeController {

    @Autowired
    OfficeDAO officeDAO;

    @GetMapping(path = "/offices")
    public List<Office> getAllOffices(){
        return officeDAO.listAllOffices();
    }

   // @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping(path = "/updateoffice")
    public void updateOffice(@Valid @RequestBody Office office){
        officeDAO.updateOffice(office);
    }

    @GetMapping(path = "/offices/doctors/{doctorId}")
    public List<Office> getOfficesByDoctor(@PathVariable int doctorId){
       return officeDAO.getOfficesByDoctor(doctorId);
    }

    @GetMapping(path = "/offices/{doctorId}")
    public List<Integer> getOfficeIdsByDoctor(@PathVariable int doctorId) {
        return officeDAO.getOfficeIdsByDoctorId(doctorId);
    }
    @GetMapping(path = "/offices/office-hours/{officeId}")
    public List<OfficeHours> getOfficeHours(@PathVariable int officeId){
        return officeDAO.getOfficeHoursByOfficeId(officeId);

    }

    @DeleteMapping(path = "/offices/{doctorId}/{officeId}")
    public void removeDoctorFromOffice(@PathVariable int doctorId, @PathVariable int officeId){
        officeDAO.removeDocFromOffice(doctorId, officeId);
    }

    @PostMapping(path = "/offices/{doctorId}/{officeId}")
    public boolean addDoctorToOffice(@PathVariable int doctorId, @PathVariable int officeId){
        return officeDAO.addDocToOffice(doctorId, officeId);
    }

    @PutMapping(path ="/office-hours")
    public void updateOfficeHours(@RequestBody OfficeHours officeHours){
        officeDAO.updateHours(officeHours);
    }

    @GetMapping(path = "/office/{officeId}")
    public Office getOfficeById(@PathVariable int officeId){
        return officeDAO.getOfficeByID(officeId);
    }
}
