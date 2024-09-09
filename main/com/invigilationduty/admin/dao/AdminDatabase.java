package main.com.invigilationduty.admin.dao;

import main.com.invigilationduty.admin.entity.Admin;
import main.com.invigilationduty.admin.entity.Hall;
import main.com.invigilationduty.faculty.entity.Faculty;

import java.util.List;

public interface AdminDatabase {
    boolean insertAdmin(Admin admin);

    Admin searchAdminByEmailIdAndPassword(Admin admin);

    Admin findAdminByEmailId(Admin admin);

    boolean addBlockNumberFloorNumberRoomNumber(Hall hall);

    List<Faculty> selectFacultyWithLeisureTIme(String leisureTime);

    Faculty randomHallAllocatedSpecifiedFaculty(Faculty faculty);

     List<Faculty> getAllFaculties();
}
