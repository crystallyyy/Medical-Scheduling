package com.techelevator.dao;

import com.techelevator.model.Office;
import com.techelevator.model.OfficeHours;

import java.util.List;

public interface OfficeDAO {
    public Office getOfficeByID(int officeId);
    public List<Office> listAllOffices();
    public boolean create();
    public boolean updateOffice(Office office);
    List<Office> getOfficesByDoctor(int id);
    List<OfficeHours> getOfficeHoursByOfficeId(int office_id);
}
