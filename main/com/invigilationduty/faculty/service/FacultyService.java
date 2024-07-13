package main.com.invigilationduty.faculty.service;

import main.com.invigilationduty.faculty.entity.Faculty;

public interface FacultyService {

    public boolean registerFaculty(Faculty faculty);

    public Faculty loginFaculty(Faculty faculty);

    public boolean passwordUpdation(Faculty faculty);

    public boolean addFacultyLeisureTime(Faculty faculty);
}
