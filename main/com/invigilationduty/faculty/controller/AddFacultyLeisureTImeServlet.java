package main.com.invigilationduty.faculty.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import main.com.invigilationduty.faculty.entity.Faculty;
import main.com.invigilationduty.faculty.service.FacultyService;
import main.com.invigilationduty.faculty.service.FacultyServiceImplementation;

import java.io.IOException;

@WebServlet("/addLeisureTime")
public class AddFacultyLeisureTImeServlet extends HttpServlet {
    FacultyService facultyService = new FacultyServiceImplementation();
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String facultyNames = request.getParameter("faculty_name");
        String facultyLeisureTime = request.getParameter("time");
        String facultyEmailId = request.getParameter("faculty_emailId");
        String[] names = facultyNames.split(" ");
        String facultyFirstName = names[0];
        String facultyLastName = names[1];
        HttpSession session  = request.getSession();
        session.setAttribute("facultyEmailId", facultyEmailId);
        Faculty faculty = new Faculty(facultyFirstName, facultyEmailId, facultyLeisureTime);
        System.out.println("Faculty First Name: " + facultyFirstName);
        System.out.println("Faculty Last Name: " + facultyLastName);
        System.out.println("Faculty Leisure Time: " + facultyLeisureTime);
        System.out.println("Faculty Email ID: " + facultyEmailId);

        boolean status = facultyService.addFacultyLeisureTime(faculty);
        RequestDispatcher dispatcher = null;
        if (status) {
            request.setAttribute("message", "Leisure Time Added");
            request.setAttribute("messageClass", "success-message");
            System.out.println("added");
            dispatcher = request.getRequestDispatcher("facultyLeisure.jsp");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("message", "Leisure Time not Added");
            request.setAttribute("messageClass", "success-message");
            System.out.println("failed");
            dispatcher = request.getRequestDispatcher("facultyLeisure.jsp");
            dispatcher.forward(request, response);
        }

    }
}
