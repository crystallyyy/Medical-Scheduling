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
<<<<<<< HEAD
    List<Integer> getOfficeIdsByDoctorId(int doctorId);
=======
    List<OfficeHours> getOfficeHoursByOfficeId(int office_id);
>>>>>>> 4129e9788a8fe5af6f0ae02a289f80935f0d8012
}
