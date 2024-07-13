package main.com.invigilationduty.admin.dao;

public interface AdminSQL {
    String INSERT_ADMIN = "INSERT INTO ADMIN_DETAILS (admin_firstName, admin_lastName, admin_emailId, admin_password) VALUES (?, ?, ?, ?)";

    String SEARCH_ADMIN_BY_EMAIL_AND_PASSWORD = "SELECT * FROM ADMIN_DETAILS WHERE admin_emailId = ? AND admin_password = ?";

    String SEARCH_ADMIN_BY_EMAIL = "SELECT * FROM ADMIN_DETAILS WHERE admin_emailId = ?";

    String INSERT_BLOCK_FLOOR_ROOM_NUMBER = "INSERT INTO HALL_DETAILS (block_name, floor_number, room_number) VALUES (?, ?, ?)";

    String UPDATE_FACULTY_HALL_DETAILS = "UPDATE FACULTY_DETAILS SET faculty_block_name=?, faculty_floor_number=?, faculty_room_number=? WHERE faculty_firstname=? AND faculty_emailId=?";

    String FACULTY_LEISURE_TIME_DATA= "SELECT faculty_firstname, faculty_emailId, faculty_leisure_time FROM FACULTY_DETAILS";


}
