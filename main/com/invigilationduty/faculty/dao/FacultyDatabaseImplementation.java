package main.com.invigilationduty.faculty.dao;

import main.com.invigilationduty.dao.Dao;
import main.com.invigilationduty.faculty.entity.Faculty;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FacultyDatabaseImplementation extends Dao implements FacultyDatabase{

    @Override
    public boolean insertFaculty(Faculty faculty) {
        boolean status = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        System.out.println("Executing...............");
        try {
            connection = getConnection();
            preparedStatement = getPreparedStatement(connection, FacultySQL.INSERT_FACULTY);
            preparedStatement.setString(1, faculty.getFirstName());
            preparedStatement.setString(2, faculty.getLastName());
            preparedStatement.setString(3, faculty.getGender());
            preparedStatement.setString(4, faculty.getPhoneNumber());
            preparedStatement.setString(5, faculty.getQualification());
            preparedStatement.setString(6, faculty.getEmailId());
            preparedStatement.setString(7, faculty.getPassword());
            preparedStatement.setString(8, faculty.getLeisureTime()); // Adding leisure time
            int row = preparedStatement.executeUpdate();
            System.out.println("Executing............... rows effected");
            if(row != 0) {
                status = true;
                System.out.println("FacultyDetails added into the database");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }

        return status;
    }

    @Override
    public Faculty searchFacultyByEmailIdAndPassword(Faculty faculty) {
        Faculty status = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            preparedStatement = getPreparedStatement(connection, FacultySQL.SEARCH_FACULTY_BY_EMAIL_AND_PASSWORD);
            preparedStatement.setString(1, faculty.getEmailId());
            preparedStatement.setString(2, faculty.getPassword());
            resultSet = getResultSet(preparedStatement);
            if(resultSet.next()) {
                faculty.setFirstName(resultSet.getString("faculty_firstname"));
                faculty.setLastName(resultSet.getString("faculty_lastname"));
                faculty.setEmailId(resultSet.getString("faculty_emailId"));
                faculty.setPassword(resultSet.getString("faculty_password"));
                status = new Faculty(faculty.getFirstName(), faculty.getLastName(), faculty.getEmailId(), faculty.getPassword());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeResultSet(resultSet);
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
        return status;
    }

    @Override
    public Faculty findFacultyByEmailId(Faculty faculty) {
        Faculty status = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            preparedStatement = getPreparedStatement(connection, FacultySQL.SEARCH_FACULTY_BY_EMAIL);
            preparedStatement.setString(1, faculty.getEmailId());
            preparedStatement.setString(2, faculty.getPassword());
            resultSet = getResultSet(preparedStatement);
            if(resultSet.next()) {
                faculty.setFirstName(resultSet.getString("faculty_firstname"));
                faculty.setLastName(resultSet.getString("faculty_lastname"));
                faculty.setEmailId(resultSet.getString("faculty_emailId"));
                faculty.setPassword(resultSet.getString("faculty_password"));
                status = new Faculty(faculty.getFirstName(), faculty.getLastName(), faculty.getEmailId(), faculty.getPassword());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeResultSet(resultSet);
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
        return status;
    }

    @Override
    public boolean addFacultyLeisureTime(Faculty faculty) {
        boolean status = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnection();
            preparedStatement = getPreparedStatement(connection, FacultySQL.ADD_FACULTY_LEISURE_TIME);
            preparedStatement.setString(1, faculty.getLeisureTime());
            preparedStatement.setString(2, faculty.getEmailId());

            System.out.println("Executing SQL: " + FacultySQL.ADD_FACULTY_LEISURE_TIME);
            System.out.println("Parameters: " + faculty.getLeisureTime() + ", " + faculty.getEmailId());

            int row = preparedStatement.executeUpdate();
            System.out.println("Rows affected: " + row);
            if(row != 0) {
                status = true;
                System.out.println("Faculty leisure Time added into the database");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
        return status;
    }
}
