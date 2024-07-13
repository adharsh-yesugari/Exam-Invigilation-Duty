package main.com.invigilationduty.admin.dao;

import main.com.invigilationduty.admin.entity.Admin;
import main.com.invigilationduty.admin.entity.Hall;
import main.com.invigilationduty.dao.Dao;
import main.com.invigilationduty.faculty.entity.Faculty;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AdminDatabaseImplementation extends Dao implements AdminDatabase{
    @Override
    public boolean insertAdmin(Admin admin) {
        boolean status  = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = getPreparedStatement(connection, AdminSQL.INSERT_ADMIN);
            preparedStatement.setString(1, admin.getFirstName());
            preparedStatement.setString(2, admin.getLastName());
            preparedStatement.setString(3, admin.getEmailId());
            preparedStatement.setString(4, admin.getPassword());
            int row = preparedStatement.executeUpdate();
            if(row != 0) {
                status  = true;
                System.out.println("Inserted Successfully");
            }
        }catch(SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
        return status;
    }

    @Override
    public Admin searchAdminByEmailIdAndPassword(Admin admin) {
        Admin status = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            preparedStatement = getPreparedStatement(connection, AdminSQL.SEARCH_ADMIN_BY_EMAIL_AND_PASSWORD);
            preparedStatement.setString(1, admin.getEmailId());
            preparedStatement.setString(2, admin.getPassword());
            resultSet = getResultSet(preparedStatement);
            if(resultSet.next()) {
                admin.setFirstName(resultSet.getString("admin_firstname"));
                admin.setLastName(resultSet.getString("admin_lastname"));
                admin.setEmailId(resultSet.getString("admin_emailId"));
                admin.setPassword(resultSet.getString("admin_password"));
                status = new Admin(admin.getFirstName(), admin.getLastName(), admin.getEmailId(), admin.getPassword());
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        } finally {
            closeResultSet(resultSet);
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
        return status;
    }

    @Override
    public Admin findAdminByEmailId(Admin admin) {
        Admin status = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            preparedStatement = getPreparedStatement(connection, AdminSQL.SEARCH_ADMIN_BY_EMAIL);
            preparedStatement.setString(1, admin.getEmailId());
            preparedStatement.setString(2, admin.getPassword());
            resultSet = getResultSet(preparedStatement);
            if(resultSet.next()) {
                admin.setFirstName(resultSet.getString("admin_firstname"));
                admin.setLastName(resultSet.getString("admin_lastname"));
                admin.setEmailId(resultSet.getString("admin_emailId"));
                admin.setPassword(resultSet.getString("admin_password"));
                status = new Admin(admin.getFirstName(), admin.getLastName(), admin.getEmailId(), admin.getPassword());
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        } finally {
            closeResultSet(resultSet);
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
        return status;
    }

    @Override
    public boolean addBlockNumberFloorNumberRoomNumber(Hall hall) {
        boolean status = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnection();
            preparedStatement = getPreparedStatement(connection, AdminSQL.INSERT_BLOCK_FLOOR_ROOM_NUMBER);
            preparedStatement.setString(1, hall.getBlockName());
            preparedStatement.setString(2, hall.getFloorNumber());
            preparedStatement.setString(3,hall.getRoomNumber());
            int row = preparedStatement.executeUpdate();
            if(row != 0) {
                status = true;
                System.out.println("Inserted Successfully");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
        return status;
    }
    @Override
    public List<Faculty> selectFacultyWithLeisureTIme(String leisureTime) {
        List<Faculty> facultyList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();
            preparedStatement = getPreparedStatement(connection, AdminSQL.FACULTY_LEISURE_TIME_DATA);
            resultSet = preparedStatement.executeQuery();

            // Use a Set to keep track of added faculty to avoid duplicates
            Set<String> addedFacultyEmails = new HashSet<>();

            while (resultSet.next()) {
                String facultyLeisureTime = resultSet.getString("faculty_leisure_time");
                String facultyEmailId = resultSet.getString("faculty_emailId");

                // Check if the faculty has the desired leisure time
                String[] time = facultyLeisureTime.split(" ");
                if (time.length > 0 && time[0].equals(leisureTime) && !addedFacultyEmails.contains(facultyEmailId)) {
                    Faculty faculty = new Faculty();
                    faculty.setFirstName(resultSet.getString("faculty_firstname"));
                    faculty.setEmailId(facultyEmailId);
                    faculty.setLeisureTime(facultyLeisureTime);
                    facultyList.add(faculty);

                    // Add faculty email to the set to prevent duplicates
                    addedFacultyEmails.add(facultyEmailId);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeResultSet(resultSet);
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }

        return facultyList;


       /* List<Faculty> facultyList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Faculty faculty = new Faculty();
        try {
            connection = getConnection();
            preparedStatement = getPreparedStatement(connection, AdminSQL.FACULTY_LEISURE_TIME_DATA);
            resultSet = getResultSet(preparedStatement);
            while(resultSet.next()) {
                String facultyLeisureTime = resultSet.getString("faculty_leisure_time");
                //System.out.println("FacultyLeisureTime : " + facultyLeisureTime);
                String[] time = facultyLeisureTime.split(" ");
                if (time.length > 0 && time[0].equals(leisureTime)) {
                    faculty.setFirstName(resultSet.getString("faculty_firstname"));
                    faculty.setEmailId(resultSet.getString("faculty_emailId"));
                    faculty.setLeisureTime(facultyLeisureTime);
                    faculty = new Faculty(faculty.getFirstName(), faculty.getEmailId(), faculty.getLeisureTime());
                   // System.out.println(faculty.toString());
                    facultyList.add(faculty);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeResultSet(resultSet);
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }

        return facultyList;*/
    }

    @Override
    public Faculty randomHallAllocatedSpecifiedFaculty(Faculty faculty) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            String SQL = "SELECT block_name, floor_number, room_number FROM HALL_DETAILS ORDER BY RAND() LIMIT 1";
            preparedStatement = getPreparedStatement(connection, SQL);
            resultSet = getResultSet(preparedStatement);
            if (resultSet.next()) {
                faculty.setBlockName(resultSet.getString("block_name"));
                faculty.setFloorNumber(resultSet.getString("floor_number"));
                faculty.setRoomNumber(resultSet.getString("room_number"));
            }
            String UPDATE_FACULTY_HALL_DETAILS = "UPDATE FACULTY_DETAILS SET faculty_block_name=?, faculty_floor_number=?, faculty_room_number=?, faculty_exam_name=?, faculty_exam_time=?, faculty_exam_date=? WHERE faculty_firstname=? AND faculty_emailId=?";
            preparedStatement = getPreparedStatement(connection, UPDATE_FACULTY_HALL_DETAILS);
            preparedStatement.setString(1, faculty.getBlockName());
            preparedStatement.setString(2, faculty.getFloorNumber());
            preparedStatement.setString(3, faculty.getRoomNumber());
            preparedStatement.setString(4, faculty.getExamName());
            preparedStatement.setString(5, faculty.getExamTime());
            preparedStatement.setString(6, faculty.getExamDate());
            preparedStatement.setString(7, faculty.getFirstName());
            preparedStatement.setString(8, faculty.getEmailId());
            int row = preparedStatement.executeUpdate();
            if (row != 0) {
                System.out.println("Block Name, Floor Number, Room Number, Exam details added");
            } else {
                System.out.println("Failed to update faculty details");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            closeResultSet(resultSet);
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
        return faculty;
    }

}
