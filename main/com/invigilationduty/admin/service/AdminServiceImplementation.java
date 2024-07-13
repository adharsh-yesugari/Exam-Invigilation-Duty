package main.com.invigilationduty.admin.service;

import main.com.invigilationduty.admin.dao.AdminDatabase;
import main.com.invigilationduty.admin.dao.AdminDatabaseImplementation;
import main.com.invigilationduty.admin.entity.Admin;
import main.com.invigilationduty.admin.entity.Hall;
import main.com.invigilationduty.faculty.entity.Faculty;

import java.util.List;

public class AdminServiceImplementation implements AdminService {
    AdminDatabase adminDatabase = new AdminDatabaseImplementation();
    @Override
    public boolean registerAdmin(Admin admin) {
        return adminDatabase.insertAdmin(admin);
    }

    @Override
    public Admin loginAdmin(Admin admin) {
        return adminDatabase.searchAdminByEmailIdAndPassword(admin);
    }

    @Override
    public boolean addBlockFloorRoomNumber(Hall hall) {
        return adminDatabase.addBlockNumberFloorNumberRoomNumber(hall);
    }

    @Override
    public List<Faculty> selectFacultyWithLeisureTime(String leisureTime) {
        return adminDatabase.selectFacultyWithLeisureTIme(leisureTime);
    }

    @Override
    public Faculty allocateRandomHalltoFacultySpecified(Faculty faculty) {
        return adminDatabase.randomHallAllocatedSpecifiedFaculty(faculty);
    }

}
