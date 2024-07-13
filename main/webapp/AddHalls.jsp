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
     <title> Exam Invigilation Duty </title>
</head>
<body>
    <jsp:include page="header.jsp"/>
    <jsp:include page="AdminNavbar.jsp"/>
    <main id="main" class="homepage">
        <div class="admin_login login">
            <form action="add_halls" method="post" class="login_form">
                <h1 class="login_title"> Add Halls</h1>
                <div class="select_options">
                    <label class="choose_blocks">Choose Block: </label>
                    <select id="select_block" class="block_options options" name="block_name">
                        <option>Select</option>
                        <option class="select_block faculty_common">Block-I</option>
                        <option class="select_block faculty_common">Block-II</option>
                        <option class="select_block faculty_common">Block-III</option>
                        <option class="select_block faculty_common">New Block</option>
                    </select>
                </div>
                <div class="select_options">
                    <label class="choose_floor">Choose Floor: </label>
                    <select id="select_floor" class="floor_options options" name="floor_number">
                        <option>Select</option>
                        <option class="select_floor faculty_common">Floor-I</option>
                        <option class="select_floor faculty_common">Floor-II</option>
                        <option class="select_floor faculty_common">Floor-III</option>
                    </select>
                </div>
                <div class="input_box">
                    <input  type="number" name="room_number" min="101" max="500" placeholder="101" required>
                </div>
                <button type="submit" class="btn">Submit</button>
            </form>
        </div>
    </main>
</body>
</html>
