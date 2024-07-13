<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="main.com.invigilationduty.dao.Dao" %>
<!DOCTYPE html>
<html lang="en">
<head>
     <meta charset="UTF-8" />
     <meta http-equiv="X-UA-Compatible" content="IE=edge" />
     <meta name="viewport" content="width=device-width, initial-scale=1.0" />
     <link href="./CSS/styles.css" rel="stylesheet">
    <style>
        .message-container {
            width: 90%;
            margin: 20px 0px;
            padding: 10px;
            text-align: center;
            background-color: #4CAF50;
            border: 1px solid #008000;
            border-radius: 5px;
        }
        .message {
            color: white;
            font-size: 18px;
        }
    </style>
     <title> Exam Invigilation Duty </title>
</head>
<body>
    <jsp:include page="header.jsp"/>
    <jsp:include page="AdminNavbar.jsp"/>
    <section id="add_faculty" class="faculty_info homepage">
    <div class="login">
        <h1 class="login_title">Faculty Leisure Time</h1>
        <form action="addLeisureTime" method="post">
        <div class="select_options">
            <label class="choose_faculty">Choose Faculty Name : </label>
            <select class="options" name="faculty_name" id="faculty_name" onchange="updateEmailId()">
                <option>Select</option>
                <%
                    Dao dao = new Dao();
                    Connection connection = null;
                    Statement statement = null;
                    ResultSet resultSet = null;
                    try {
                        connection = dao.getConnection();
                        statement = connection.createStatement();
                        resultSet = statement.executeQuery("SELECT faculty_firstname, faculty_lastname, faculty_emailId FROM FACULTY_DETAILS");
                        while(resultSet.next()){
                            String facultyFirstName = resultSet.getString("faculty_firstname");
                            String facultyLastName = resultSet.getString("faculty_lastname");
                            String facultyEmailId = resultSet.getString("faculty_emailId");
                %>
                <option class="faculty_common" value="<%= facultyFirstName %> <%= facultyLastName %>" data-email="<%= facultyEmailId %>">
                    <%= facultyFirstName %> <%= facultyLastName %>
                </option>
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
            </select>
        </div>
         <input type="hidden" name="faculty_emailId" id="faculty_emailId">
        <div class="select_options">
            <label class="choose_faculty_leisure_time">Choose Leisure Time : </label>
            <select id="faculty_time_select" class="time_options options" name="time">
                <option>Select</option>
                <option class="faculty_time faculty_common">9AM - 10AM</option>
                <option class="faculty_time faculty_common">10AM - 11AM</option>
                <option class="faculty_time faculty_common">11AM - 12PM</option>
                <option class="faculty_time faculty_common">1PM - 2PM</option>
                <option class="faculty_time faculty_common">2PM - 3PM</option>
                <option class="faculty_time faculty_common">3PM - 4PM</option>
            </select>
        </div>
            <button type="submit" class="btn">Submit</button>
        <%
            String messageClass = (String) request.getAttribute("messageClass");
            if (messageClass != null && messageClass.equals("success-message")) {
                String message = (String) request.getAttribute("message");
        %>
            <div class="message-container">
                <p class="message"><i class="fas fa-check-circle"></i><%= message %></p>
            </div>
        <% } else {
                String errorMessage = (String) request.getAttribute("errorMessage");
                if (errorMessage != null) {
        %>
            <div class="message-container">
                <p class="message"><i class="fas fa-exclamation-circle"></i><%= errorMessage %></p>
            </div>
        <%      }
            }
        %>
        </form>
    </div>

    </section>

     <script>
        function updateEmailId() {
            const select = document.getElementById('faculty_name');
            const selectedOption = select.options[select.selectedIndex];
            const emailId = selectedOption.getAttribute('data-email');
            document.getElementById('faculty_emailId').value = emailId;
        }
        window.onload = updateEmailId;
     </script>
</body>
</html>
