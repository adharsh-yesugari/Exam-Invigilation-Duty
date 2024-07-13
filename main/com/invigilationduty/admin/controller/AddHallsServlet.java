package main.com.invigilationduty.admin.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import main.com.invigilationduty.admin.entity.Hall;
import main.com.invigilationduty.admin.service.AdminService;
import main.com.invigilationduty.admin.service.AdminServiceImplementation;

import java.io.IOException;

@WebServlet("/add_halls")
public class AddHallsServlet extends HttpServlet {
    AdminService adminService = new AdminServiceImplementation();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String blockName = request.getParameter("block_name");
        String floorNumber = request.getParameter("floor_number");
        String roomNumber = request.getParameter("room_number");
        Hall hall = new Hall(blockName, floorNumber, roomNumber);
        boolean status = adminService.addBlockFloorRoomNumber(hall);
        RequestDispatcher dispatcher = null;
        if (status) {
            response.setStatus(201);
            dispatcher = request.getRequestDispatcher("AddHalls.jsp");
            dispatcher.forward(request, response);
        } else {
            response.setStatus(400);
            dispatcher = request.getRequestDispatcher("AddHalls.jsp");
            dispatcher.forward(request, response);
        }
    }
}
