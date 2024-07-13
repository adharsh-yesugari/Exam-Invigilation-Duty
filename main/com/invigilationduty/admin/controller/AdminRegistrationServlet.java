package main.com.invigilationduty.admin.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import main.com.invigilationduty.admin.entity.Admin;
import main.com.invigilationduty.admin.service.AdminService;
import main.com.invigilationduty.admin.service.AdminServiceImplementation;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/registration")
public class AdminRegistrationServlet extends HttpServlet {
    AdminService adminService = new AdminServiceImplementation();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String adminFirstName = request.getParameter("firstname");
        String adminLastName = request.getParameter("lastname");
        String adminEmail = request.getParameter("email");
        String adminPassword = request.getParameter("password");
        Admin admin = new Admin(adminFirstName, adminLastName, adminEmail, adminPassword);
        boolean status = adminService.registerAdmin(admin);
        RequestDispatcher dispatcher = null;
        if (status) {
            request.setAttribute("message", "User Registered");
            request.setAttribute("messageClass", "success-message");
            dispatcher = request.getRequestDispatcher("AdminRegister.jsp");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("message", "Unsuccessful Registration");
            request.setAttribute("messageClass", "error-message");
            dispatcher = request.getRequestDispatcher("AdminRegister.jsp");
            dispatcher.forward(request, response);
        }
    }
}
