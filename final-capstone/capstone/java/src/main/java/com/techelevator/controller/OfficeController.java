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

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping(path = "/updateoffice")
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
}
