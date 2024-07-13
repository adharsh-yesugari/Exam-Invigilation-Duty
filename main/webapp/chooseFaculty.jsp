<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.util.Random" %>
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
        <div class="login">
            <h1 class="login_title">Select Faculty with Leisure</h1>
             <form action="select_faculty_for_leisure" method="post">
                <div class="select_options">
                    <label class="choose_faculty">Choose Examination Name : </label>
                    <select class="options" name="exam_name" id="exam_name">
                        <option>Select</option>
                        <option class="exam_name faculty_common">Mid-I Examination</option>
                        <option class="exam_name faculty_common">Mid-II Examination</option>
                        <option class="exam_name faculty_common">Semister Examination</option>
                    </select>
                </div>
                <div class="select_options">
                    <label class="choose_faculty_leisure_time">Choose Exam Time : </label>
                    <select id="exam_time_select" class="time_options options" name="exam_time">
                        <option>Select</option>
                        <option class="exam_time faculty_common">9AM - 12PM</option>
                        <option class="exam_time faculty_common">10AM - 1PM</option>
                        <option class="exam_time faculty_common">1PM - 4PM</option>
                    </select>
                </div>
                <div class="select_options">
                    <label for="exam_date">Select Date:</label><br>
                    <input type="date" id="exam_data" name="exam_date" class="options">
                </div>
                <button type="submit" class="btn">Submit</button>
             </form>
             <%
                String message = (String) request.getAttribute("message");
             %>
             <%
                if (message != null) { %>
                    <p><%= message %></p>
            <%  }
            %>
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
