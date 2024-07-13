package main.com.invigilationduty.faculty.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import main.com.invigilationduty.faculty.entity.Faculty;
import main.com.invigilationduty.faculty.service.FacultyService;
import main.com.invigilationduty.faculty.service.FacultyServiceImplementation;

import java.io.IOException;

@WebServlet("/add_faculty_info")

public class FacultyRegistrationServlet extends HttpServlet {
    FacultyService facultyService = new FacultyServiceImplementation();
    private HttpServletRequest request;
    private HttpServletResponse response;
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String facultyName = request.getParameter("facultyName");
        String facultyGender = request.getParameter("gender");
        String facultyPhoneNumber = request.getParameter("phoneNumber");
        String facultyQualification = request.getParameter("qualification");
        String facultyEmailId = request.getParameter("email");
        String facultyPassword = request.getParameter("password");
        String facultyLeisureTime = request.getParameter("leisureTime"); // Add this line
        String[] facultyNameArray = facultyName.split(" ");
        String facultyFirstName = facultyNameArray[0];
        String facultyLastName = "";
        for (int i = 1; i < facultyNameArray.length; i++) {
            facultyLastName += facultyNameArray[i] + " ";
        }
        System.out.println("Adding Details");
        Faculty faculty = new Faculty(facultyFirstName, facultyLastName, facultyGender, facultyPhoneNumber, facultyQualification, facultyEmailId, facultyPassword);
        boolean status = facultyService.registerFaculty(faculty);
        System.out.println("Status : " + status);
        RequestDispatcher dispatcher = null;
        if (status) {
            request.setAttribute("message", "Faculty Added");
            request.setAttribute("messageClass", "success-message");
            dispatcher = request.getRequestDispatcher("addFaculty.jsp");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("message", "Faculty Not Added");
            request.setAttribute("messageClass", "error-message");
            dispatcher = request.getRequestDispatcher("AdminHome.jsp");
            dispatcher.forward(request, response);
        }
    }
}
