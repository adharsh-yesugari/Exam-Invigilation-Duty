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

@WebServlet("/faculty_login_form")
public class FacultyLoginServlet extends HttpServlet {
    private FacultyService facultyService = new FacultyServiceImplementation();
    private HttpServletRequest request;
    private HttpServletResponse response;
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        RequestDispatcher requestDispatcher = null;
        HttpSession session = request.getSession();
        String cookieStatus = (String) session.getAttribute("COOKIESTATUS");

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String facultyEmailId = request.getParameter("email");
        String facultyPassword = request.getParameter("password");
        HttpSession session  = request.getSession();
        session.setAttribute("facultyEmailId", facultyEmailId);
        Faculty faculty = new Faculty(facultyEmailId, facultyPassword);
        Faculty result = facultyService.loginFaculty(faculty);
        RequestDispatcher requestDispatcher = null;
        if(result !=  null) {
            requestDispatcher = request.getRequestDispatcher("FacultyHome.jsp");
            requestDispatcher.forward(request, response);
            //System.out.println(result);
            System.out.println("Login Successful");
        } else {
            requestDispatcher = request.getRequestDispatcher("FacultyLogin.jsp");
            requestDispatcher.forward(request, response);
            //System.out.println(result);
            System.out.println("Login Failed");
        }
    }
}
