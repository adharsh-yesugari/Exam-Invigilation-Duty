package main.com.invigilationduty.admin.service;

import main.com.invigilationduty.admin.entity.Admin;
import main.com.invigilationduty.admin.entity.Hall;
import main.com.invigilationduty.faculty.entity.Faculty;

import java.util.List;

public interface AdminService {
    boolean registerAdmin(Admin admin);

    Admin loginAdmin(Admin admin);

    boolean addBlockFloorRoomNumber(Hall hall);

    List<Faculty> selectFacultyWithLeisureTime(String leisureTime);

    Faculty allocateRandomHalltoFacultySpecified(Faculty faculty);

    List<Faculty> getFacultyList();
}
