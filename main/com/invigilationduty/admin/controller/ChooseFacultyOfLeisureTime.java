package main.com.invigilationduty.admin.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import main.com.invigilationduty.admin.service.AdminService;
import main.com.invigilationduty.admin.service.AdminServiceImplementation;
import main.com.invigilationduty.faculty.entity.Faculty;

import java.io.IOException;
import java.util.List;

@WebServlet("/chooseFacultyForLeisureTime")
public class ChooseFacultyOfLeisureTime extends HttpServlet {
    AdminService adminService = new AdminServiceImplementation();
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String randomSelection = request.getParameter("randomSelection");
        String examName = request.getParameter("exam_name");
        String examTime = request.getParameter("exam_time");
        String examDate = request.getParameter("exam_date");

        Faculty faculty = null;

        if (randomSelection != null && randomSelection.equals("true")) {
            // Handle random selection
            List<Faculty> facultyList = adminService.getFacultyList();
            if (facultyList != null && !facultyList.isEmpty()) {
                faculty = facultyList.get(new java.util.Random().nextInt(facultyList.size()));
            }
        }

        if (faculty != null) {
            faculty.setExamName(examName);
            faculty.setExamTime(examTime);
            faculty.setExamDate(examDate);

            Faculty updatedFaculty = adminService.allocateRandomHalltoFacultySpecified(faculty);

            request.setAttribute("updatedFaculty", updatedFaculty);

            RequestDispatcher dispatcher = request.getRequestDispatcher("ViewSchedule.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("index.jsp");
        }

    }
}
