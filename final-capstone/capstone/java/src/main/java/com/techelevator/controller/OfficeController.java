package com.techelevator.controller;

import com.techelevator.dao.OfficeDAO;
import com.techelevator.model.Office;
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
}