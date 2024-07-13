<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="main.com.invigilationduty.dao.Dao" %>
<!DOCTYPE html>
<html lang="en">
<head>
     <meta charset="UTF-8" />
     <meta http-equiv="X-UA-Compatible" content="IE=edge" />
     <meta name="viewport" content="width=device-width, initial-scale=1.0" />
     <link href="./CSS/styles.css" rel="stylesheet">
     <title> Exam Invigilation Duty </title>
</head>
<body>
    <jsp:include page="header.jsp"/>
    <jsp:include page="AdminNavbar.jsp"/>
    <section id="add_faculty" class="faculty_info homepage">
        <table class="faculty_table" border="1">
            <thead>
                <tr>
                    <th>First Name</th>
                    <th>Email</th>
                    <th>Exam Date</th>
                    <th>Exam Time</th>
                    <th>Block Name</th>
                    <th>Floor Number</th>
                    <th>Room Number</th>
                </tr>
            </thead>
            <tbody>
                <%
                    Dao dao = new Dao();
                    Connection connection = null;
                    PreparedStatement statement = null;
                    ResultSet resultSet = null;

                    try {
                        connection = dao.getConnection();
                         statement = connection.prepareStatement("SELECT faculty_firstname, faculty_emailId, faculty_exam_date, faculty_exam_time, faculty_block_name, faculty_floor_number, faculty_room_number FROM FACULTY_DETAILS WHERE faculty_block_name != 'N/A' AND faculty_floor_number != 'N/A' AND faculty_room_number != 'N/A'");
                        resultSet = statement.executeQuery();

                        while (resultSet.next()) {
                            String facultyFirstName = resultSet.getString("faculty_firstname");
                            String facultyEmailId = resultSet.getString("faculty_emailId");
                            String facultyExamDate = resultSet.getString("faculty_exam_date");
                            String facultyExamTime = resultSet.getString("faculty_exam_time");
                            String facultyBlockName = resultSet.getString("faculty_block_name");
                            String facultyFloorNumber = resultSet.getString("faculty_floor_number");
                            String facultyRoomNumber = resultSet.getString("faculty_room_number");
                %>
                <tr>
                    <td><%= facultyFirstName %></td>
                    <td><%= facultyEmailId %></td>
                    <td><%= facultyExamDate %></td>
                    <td><%= facultyExamTime %></td>
                    <td><%= facultyBlockName %></td>
                    <td><%= facultyFloorNumber %></td>
                    <td><%= facultyRoomNumber %></td>
                </tr>
                <%
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        dao.closeResultSet(resultSet);
                        dao.closeStatement(statement);
                        dao.closeConnection(connection);
                    }
                %>
            </tbody>
        </table>
    </section>
</body>
</html>