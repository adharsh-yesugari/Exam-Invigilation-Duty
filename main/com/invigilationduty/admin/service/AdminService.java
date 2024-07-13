package main.com.invigilationduty.admin.service;

import main.com.invigilationduty.admin.entity.Admin;
import main.com.invigilationduty.admin.entity.Hall;
import main.com.invigilationduty.faculty.entity.Faculty;

import java.util.List;

public interface AdminService {
    public boolean registerAdmin(Admin admin);

    public Admin loginAdmin(Admin admin);

    public boolean addBlockFloorRoomNumber(Hall hall);

    public List<Faculty> selectFacultyWithLeisureTime(String leisureTime);

    Faculty allocateRandomHalltoFacultySpecified(Faculty faculty);
}
