<%@ page import="java.util.List" %>
<%@ page import="main.com.invigilationduty.faculty.entity.Faculty" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="./CSS/styles.css" rel="stylesheet">
    <title>Faculty Schedule</title>
</head>
<body>
    <jsp:include page="header.jsp"/>
    <main class="faculty_schedule">
        <h1 class="schedule_title">Faculty Invigilation Duty Schedule</h1>
        <table border="1" class="schedule_table">
            <thead>
                <tr>
                    <th>Faculty Name</th>
                    <th>Exam Name</th>
                    <th>Exam Date</th>
                    <th>Exam Time</th>
                    <th>Room Number</th>
                    <th>Block Name</th>
                    <th>Floor Number</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Faculty> facultyScheduleList = (List<Faculty>) request.getAttribute("facultyScheduleList");
                    if (facultyScheduleList != null && !facultyScheduleList.isEmpty()) {
                        for (Faculty facultySchedule : facultyScheduleList) {
                %>
                <tr>
                    <td><%= facultySchedule.getFirstName() %></td>
                    <td><%= facultySchedule.getExamName() %></td>
                    <td><%= facultySchedule.getExamDate() %></td>
                    <td><%= facultySchedule.getExamTime() %></td>
                    <td><%= facultySchedule.getRoomNumber() %></td>
                    <td><%= facultySchedule.getBlockName() %></td>
                    <td><%= facultySchedule.getFloorNumber() %></td>
                </tr>
                <%
                        }
                    } else {
                %>
                <tr>
                    <td colspan="7">No schedule available</td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </main>
</body>
</html>
