package main.com.invigilationduty.faculty.dao;

public interface FacultySQL {
    String INSERT_FACULTY = "INSERT INTO FACULTY_DETAILS (faculty_firstname, faculty_lastname, faculty_gender, faculty_phonenumber, faculty_qualification, faculty_emailId, faculty_password, faculty_leisure_time) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    String SEARCH_FACULTY_BY_EMAIL_AND_PASSWORD = "SELECT faculty_firstname, faculty_lastname, faculty_emailID, faculty_password FROM FACULTY_DETAILS WHERE faculty_emailId = ? AND faculty_password = ?";

    String SEARCH_FACULTY_BY_EMAIL = "SELECT faculty_firstname, faculty_lastname, faculty_emailID, faculty_password FROM FACULTY_DETAILS WHERE faculty_emailId = ?";

    String ADD_FACULTY_LEISURE_TIME ="UPDATE FACULTY_DETAILS SET faculty_leisure_time = ? WHERE faculty_emailId = ?";
}
