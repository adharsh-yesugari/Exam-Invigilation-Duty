package main.com.invigilationduty.admin.dao;

import main.com.invigilationduty.admin.entity.Admin;
import main.com.invigilationduty.admin.entity.Hall;
import main.com.invigilationduty.faculty.entity.Faculty;

import java.util.List;

public interface AdminDatabase {
    public boolean insertAdmin(Admin admin);

    public Admin searchAdminByEmailIdAndPassword(Admin admin);

    public Admin findAdminByEmailId(Admin admin);

    public boolean addBlockNumberFloorNumberRoomNumber(Hall hall);

    public List<Faculty> selectFacultyWithLeisureTIme(String leisureTime);

    Faculty randomHallAllocatedSpecifiedFaculty(Faculty faculty);
}
