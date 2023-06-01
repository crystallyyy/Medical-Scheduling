package com.techelevator.dao;

import com.techelevator.model.Office;

import java.util.List;

public interface OfficeDAO {
    public Office getOfficeByID(int officeId);
    public List<Office> findAllOffices();
    public boolean create();
}
