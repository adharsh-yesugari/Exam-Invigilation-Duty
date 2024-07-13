<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="main.com.invigilationduty.faculty.entity.Faculty" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="./CSS/styles.css" rel="stylesheet">
    <title>Exam Invigilation Duty</title>
</head>
<body>
    <jsp:include page="header.jsp"/>
    <jsp:include page="AdminNavbar.jsp"/>
    <section id="faculty_list" class="faculty_info homepage">
        <div class="container">
            <h1 class="login_title">Faculty List</h1>
            <table border="1">
                <thead>
                    <tr>
                        <th>First Name</th>
                        <th>Email ID</th>
                        <th>Choose</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<Faculty> facultyList = (List<Faculty>) request.getAttribute("facultyList");
                        String examName = (String) request.getAttribute("exam_name");
                        String examTime = (String) request.getAttribute("exam_time");
                        String examDate = (String) request.getAttribute("exam_date");
                        if (facultyList != null) {
                            for (Faculty faculty : facultyList) {
                    %>
                    <tr>
                        <td><%= faculty.getFirstName() %></td>
                        <td><%= faculty.getEmailId() %></td>
                        <td>
                            <form action="chooseFacultyForLeisureTime" method="post">
                                <input type="hidden" name="facultyFirstName" value="<%= faculty.getFirstName() %>">
                                <input type="hidden" name="facultyEmail" value="<%= faculty.getEmailId() %>">
                                <input type="hidden" name="exam_name" value="<%= examName %>">
                                <input type="hidden" name="exam_time" value="<%= examTime %>">
                                <input type="hidden" name="exam_date" value="<%= examDate %>">
                                <button type="submit">Choose</button>
                            </form>
                        </td>
                    </tr>
                    <%
                            }
                        } else {
                    %>
                    <tr>
                        <td colspan="3">No faculty available</td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>
    </section>
</body>
</html>
