package com.example.casestudy.controller;

import com.example.casestudy.model.Customer;
import com.example.casestudy.model.Order;
import com.example.casestudy.model.OrderDetail;
import com.example.casestudy.model.Pet;
import com.example.casestudy.service.OrderDetailManager;
import com.example.casestudy.service.OrderManager;
import com.example.casestudy.service.PetManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "OrderServlet", value = "/OrderServlet")
public class OrderServlet extends HttpServlet {
    PetManager petManager = new PetManager();
    OrderManager orderManager = new OrderManager();
    OrderDetailManager orderDetailManager = new OrderDetailManager();
    SignInSignUpServlet signInSignUpServlet = new SignInSignUpServlet();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "createOrder":
                createOrder(request, response);
                break;
            case "addToCart":
                addToCart(request, response);
                break;
            case "showCart":
                showCart(request, response);
                break;
            case "deleteCart":
                deleteCart(request, response);
                break;
            case "deleteAllCart":
                deleteAllCart(request, response);
                break;
            case "order":
                order(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void createOrder(HttpServletRequest request, HttpServletResponse response) {

    }

    public void addToCart(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Pet pet = petManager.findById(id);
        HttpSession session = request.getSession();
        ArrayList<Pet> petsListCart = (ArrayList<Pet>) session.getAttribute("petsListCart");
        boolean check = true;
        if (petsListCart != null) {
            for (Pet p : petsListCart) {
                if (p.getId() == id) {
                    check = false;
                    JOptionPane.showMessageDialog(null,"Pet đã có trong giỏ hàng!","Thông báo",
                            JOptionPane.INFORMATION_MESSAGE);
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/homeCustomer.jsp");
                    requestDispatcher.forward(request, response);
                    break;
                }
            }
            if (check) {
                petsListCart.add(pet);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/homeCustomer.jsp");
                session.setAttribute("petsListCart", petsListCart);
                requestDispatcher.forward(request, response);
                System.out.println("Done!");
            }
        } else {
            petsListCart = new ArrayList<>();
            petsListCart.add(pet);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/homeCustomer.jsp");
            session.setAttribute("petsListCart", petsListCart);
            requestDispatcher.forward(request, response);
            System.out.println("Them vao gio hang thanh cong!");
        }
    }

    public void showCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ArrayList<Pet> petsListCart = (ArrayList<Pet>) session.getAttribute("petsListCart");
        String totalPriceTemp;
        if (petsListCart == null) {
            totalPriceTemp = "Ban chua mua san pham nao!";
        } else {
            totalPriceTemp = orderManager.totalPriceTemp(petsListCart);
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/showCart.jsp");
        session.setAttribute("petsListCart", petsListCart);
        session.setAttribute("totalPriceTemp", totalPriceTemp);
        requestDispatcher.forward(request, response);
    }

    public void deleteCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        HttpSession session = request.getSession();
        ArrayList<Pet> petsListCart = (ArrayList<Pet>) session.getAttribute("petsListCart");
        int result = JOptionPane.showConfirmDialog(null,
                "Bạn có muốn xóa không?",
                "Xác nhận",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.YES_OPTION) {
            for (Pet pet : petsListCart) {
                if (pet.getId() == id) {
                    petsListCart.remove(pet);
                    break;
                }
            }
            session.setAttribute("petsListCart", petsListCart);
            showCart(request, response);
        } else {
            showCart(request, response);
        }
    }

    public void deleteAllCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ArrayList<Pet> petsListCart = (ArrayList<Pet>) session.getAttribute("petsListCart");
        int result = JOptionPane.showConfirmDialog(null,
                "Bạn có muốn xóa toàn bộ giỏ hàng không?",
                "Xác nhận",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.YES_OPTION) {
            petsListCart.clear();
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/homeCustomer.jsp");
            session.setAttribute("petsListCart", null);
            requestDispatcher.forward(request, response);
        } else {
            showCart(request, response);
        }
    }

    public void order(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        ArrayList<Pet> petsListCart = (ArrayList<Pet>) session.getAttribute("petsListCart");
        Customer customer = (Customer) session.getAttribute("customer");
        Order order = new Order(customer);
        int result = JOptionPane.showConfirmDialog(null,
                "Bạn có muốn thanh toán luôn không?",
                "Xác nhận",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.YES_OPTION) {
            order.setStatus("Paid");
            JOptionPane.showMessageDialog(null, "Cảm ơn bạn đã mua hàng!", "Thanh toán",
                    JOptionPane.INFORMATION_MESSAGE);
            orderManager.create(order);
            Order order1 = orderManager.findOrderNew();
            for (Pet pet : petsListCart) {
                OrderDetail orderDetail = new OrderDetail(pet, order1);
                orderDetailManager.create(orderDetail);
                petManager.updatePetAfterBuy(pet);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Hãy thanh toán sớm trước khi đơn hàng bị hủy!", "Thông báo",
                    JOptionPane.INFORMATION_MESSAGE);
            orderManager.create(order);
            Order order1 = orderManager.findOrderNew();
            for (Pet pet : petsListCart) {
                OrderDetail orderDetail = new OrderDetail(pet, order1);
                orderDetailManager.create(orderDetail);
            }
        }
        petsListCart.clear();
        session.setAttribute("petsListCart", petsListCart);
        signInSignUpServlet.displayCustomer(request,response,customer);
    }
}