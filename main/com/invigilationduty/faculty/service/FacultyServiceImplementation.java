package main.com.invigilationduty.faculty.service;

import main.com.invigilationduty.faculty.dao.FacultyDatabase;
import main.com.invigilationduty.faculty.dao.FacultyDatabaseImplementation;
import main.com.invigilationduty.faculty.entity.Faculty;

public class FacultyServiceImplementation implements FacultyService{
    FacultyDatabase facultyDatabase = new FacultyDatabaseImplementation();
    @Override
    public boolean registerFaculty(Faculty faculty) {
        return facultyDatabase.insertFaculty(faculty);
    }

    @Override
    public Faculty loginFaculty(Faculty faculty) {
        return facultyDatabase.searchFacultyByEmailIdAndPassword(faculty);
    }

    @Override
    public boolean passwordUpdation(Faculty faculty) {
        return false;
    }

    @Override
    public boolean addFacultyLeisureTime(Faculty faculty) {
        return facultyDatabase.addFacultyLeisureTime(faculty);
    }
}
