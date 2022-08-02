package com.example.casestudy.controller;

import com.example.casestudy.model.Service;
import com.example.casestudy.service.ServiceManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServiceServlet", value = "/ServiceServlet")
public class ServiceServlet extends HttpServlet {
    ServiceManager serviceManager = new ServiceManager();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void createServiceGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("service/createService.jsp");
        requestDispatcher.forward(request,response);
    }

    public void createServicePost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        try {
            String serviceName = request.getParameter("serviceName");
            int price = Integer.parseInt(request.getParameter("price"));
            int serviceDay = Integer.parseInt(request.getParameter("serviceDay"));
            Service service = new Service(serviceName, price, serviceDay);
        } catch (Exception e) {
            String priceFailMessage = "Giá không hợp lệ!";
            request.setAttribute("priceFailMessage", priceFailMessage);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("service/createService.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    public void updateServiceGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Service service = serviceManager.findById(id);
        request.setAttribute("service",service);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("service/updateService.jsp");
        requestDispatcher.forward(request,response);
    }

    public void updateServicePost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        try {
            String serviceName = request.getParameter("serviceName");
            int price = Integer.parseInt(request.getParameter("price"));
            int serviceDay = Integer.parseInt(request.getParameter("serviceDay"));
            Service service = new Service(serviceName,price,serviceDay);
            serviceManager.update(service);
            response.sendRedirect("/ServiceServlet?action=default");
        } catch (NumberFormatException | IOException e) {
            String priceFailMessage = "Giá không hợp lệ!";
            request.setAttribute("priceFailMessage", priceFailMessage);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("service/updateService.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    public void deleteServiceGet(HttpServletRequest request,HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        serviceManager.deleteById(id);
    }

    public void deleteServicePost(HttpServletRequest request,HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        serviceManager.deleteById(id);
        response.sendRedirect("/ServiceServlet?action=default");
    }
}