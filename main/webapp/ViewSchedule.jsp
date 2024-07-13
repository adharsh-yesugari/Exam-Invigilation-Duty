<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="main.com.invigilationduty.faculty.entity.Faculty" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="./CSS/styles.css" rel="stylesheet">
    <title>View Schedule</title>
</head>
<body>
    <jsp:include page="header.jsp"/>
    <jsp:include page="AdminNavbar.jsp"/>
    <section id="view_schedule" class="view_schedule homepage">
        <div class="container">
            <h1>Faculty Invigilation Schedule</h1>
            <table border="1">
                <tr>
                    <th>First Name</th>
                    <td><%= ((Faculty) request.getAttribute("updatedFaculty")).getFirstName() %></td>
                </tr>
                <tr>
                    <th>Email ID</th>
                    <td><%= ((Faculty) request.getAttribute("updatedFaculty")).getEmailId() %></td>
                </tr>
                <tr>
                    <th>Block Name</th>
                    <td><%= ((Faculty) request.getAttribute("updatedFaculty")).getBlockName() %></td>
                </tr>
                <tr>
                    <th>Floor Number</th>
                    <td><%= ((Faculty) request.getAttribute("updatedFaculty")).getFloorNumber() %></td>
                </tr>
                <tr>
                    <th>Room Number</th>
                    <td><%= ((Faculty) request.getAttribute("updatedFaculty")).getRoomNumber() %></td>
                </tr>
                <tr>
                    <th>Exam Name</th>
                    <td><%= ((Faculty) request.getAttribute("updatedFaculty")).getExamName() %></td>
                </tr>
                <tr>
                    <th>Exam Time</th>
                    <td><%= ((Faculty) request.getAttribute("updatedFaculty")).getExamTime() %></td>
                </tr>
                <tr>
                    <th>Exam Date</th>
                    <td><%= ((Faculty) request.getAttribute("updatedFaculty")).getExamDate() %></td>
                </tr>
            </table>
        </div>
    </section>
</body>
</html>
