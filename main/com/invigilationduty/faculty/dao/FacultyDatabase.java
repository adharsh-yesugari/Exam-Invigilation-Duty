package main.com.invigilationduty.faculty.dao;

import main.com.invigilationduty.admin.entity.Admin;
import main.com.invigilationduty.faculty.entity.Faculty;

public interface FacultyDatabase {
    public boolean insertFaculty(Faculty faculty);

    public Faculty searchFacultyByEmailIdAndPassword(Faculty faculty);

    public Faculty findFacultyByEmailId(Faculty faculty);

    public boolean addFacultyLeisureTime(Faculty faculty);
}
