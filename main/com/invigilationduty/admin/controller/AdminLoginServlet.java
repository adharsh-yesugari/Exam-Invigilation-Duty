package main.com.invigilationduty.admin.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import main.com.invigilationduty.admin.entity.Admin;
import main.com.invigilationduty.admin.service.AdminService;
import main.com.invigilationduty.admin.service.AdminServiceImplementation;

import java.io.IOException;

@WebServlet("/adminLogin")
public class AdminLoginServlet extends HttpServlet {
    private AdminService adminService = new AdminServiceImplementation();
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
        String adminEmailId = request.getParameter("email");
        String adminpassword = request.getParameter("password");
        HttpSession session = request.getSession();
        session.setAttribute("adminEmailId", adminEmailId);
        Admin admin = new Admin(adminEmailId, adminpassword);
        Admin result = adminService.loginAdmin(admin);
        RequestDispatcher dispatcher = null;
        if(result != null) {
            dispatcher = request.getRequestDispatcher("AdminHome.jsp");
            dispatcher.forward(request, response);
        } else {
            dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }
    }
}
