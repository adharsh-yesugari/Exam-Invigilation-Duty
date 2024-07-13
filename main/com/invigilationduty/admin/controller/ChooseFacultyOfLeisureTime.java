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

@WebServlet("/chooseFacultyForLeisureTime")
public class ChooseFacultyOfLeisureTime extends HttpServlet {
    AdminService adminService = new AdminServiceImplementation();
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve selected faculty details from form submission
        System.out.println("Executing this Method");
        String facultyFirstName = request.getParameter("facultyFirstName");
        String facultyEmail = request.getParameter("facultyEmail");
        String examName = request.getParameter("exam_name");
        String examTime = request.getParameter("exam_time");
        String examDate = request.getParameter("exam_date");
        System.out.println("facultyName : " + facultyFirstName + " facultyEmailid : " + facultyEmail);
        System.out.println("ExamName : " + examName + " " + "Exam_time : " + examTime + " ExamData : " +examDate);
        Faculty faculty = new Faculty(facultyFirstName, facultyEmail, examName, examTime, examDate);
        Faculty updatedFaculty = adminService.allocateRandomHalltoFacultySpecified(faculty);

        System.out.println(updatedFaculty.toString());

        request.setAttribute("updatedFaculty", updatedFaculty);

        RequestDispatcher dispatcher = request.getRequestDispatcher("ViewSchedule.jsp");
        dispatcher.forward(request, response);
    }
}
