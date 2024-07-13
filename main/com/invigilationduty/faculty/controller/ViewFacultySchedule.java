package main.com.invigilationduty.faculty.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import main.com.invigilationduty.dao.Dao;
import main.com.invigilationduty.faculty.entity.Faculty;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ViewFacultySchedule")
public class ViewFacultySchedule extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String facultyEmailId = (String)session.getAttribute("facultyEmailId");
        System.out.println("Faculty Email id : " + facultyEmailId);
        if(facultyEmailId != null) {
            System.out.println("Executing.......");
            Dao dao = new Dao();
            Connection connection = null;
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            List<Faculty> facultyScheduleList = new ArrayList<>();
            try {
                connection = dao.getConnection();
                String SQL = "SELECT faculty_firstname, faculty_emailId, faculty_exam_name, faculty_exam_date, faculty_exam_time, faculty_block_name, faculty_floor_number, faculty_room_number FROM FACULTY_DETAILS WHERE faculty_emailId = ?";
                preparedStatement = dao.getPreparedStatement(connection, SQL);
                preparedStatement.setString(1, facultyEmailId);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Faculty facultySchedule = new Faculty();
                    facultySchedule.setFirstName(resultSet.getString("faculty_firstname"));
                    facultySchedule.setFirstName(resultSet.getString("faculty_emailId"));
                    facultySchedule.setExamName(resultSet.getString("faculty_exam_name"));
                    facultySchedule.setExamDate(resultSet.getString("faculty_exam_date"));
                    facultySchedule.setExamTime(resultSet.getString("faculty_exam_time"));
                    facultySchedule.setBlockName(resultSet.getString("faculty_block_name"));
                    facultySchedule.setFloorNumber(resultSet.getString("faculty_floor_number"));
                    facultySchedule.setRoomNumber(resultSet.getString("faculty_room_number"));
                    facultyScheduleList.add(facultySchedule);
                }
                System.out.println("faculty List : "+facultyScheduleList.toString());
                request.setAttribute("facultyScheduleList", facultyScheduleList);
                request.getRequestDispatcher("ViewFacultySchedule.jsp").forward(request, response);

            } catch (SQLException | ServletException | IOException e) {
                throw new RuntimeException(e);
            }finally {
                dao.closeResultSet(resultSet);
                dao.closePreparedStatement(preparedStatement);
                dao.closeConnection(connection);
            }
        } else {
            response.sendRedirect("FacultyLogin.jsp");
        }
    }
}
