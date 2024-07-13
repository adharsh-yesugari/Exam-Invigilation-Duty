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

@WebServlet("/select_faculty_for_leisure")
public class SelectFacultyWithLeisureTime extends HttpServlet {
    AdminService adminService = new AdminServiceImplementation();
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String exam_name = request.getParameter("exam_name");
        String exam_time = request.getParameter("exam_time");
        String exam_date = request.getParameter("exam_date");
        String[] time = exam_time.split(" ");
        String leisure_time = time[0];
        List<Faculty> facultyList = adminService.selectFacultyWithLeisureTime(leisure_time);
        System.out.println(facultyList.toString());
        request.setAttribute("facultyList", facultyList);
        request.setAttribute("exam_name", exam_name);
        request.setAttribute("exam_time", exam_time);
        request.setAttribute("exam_date", exam_date);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("displayFacultyWithSelectedLeisureTime.jsp");
        requestDispatcher.forward(request, response);

    }
}
