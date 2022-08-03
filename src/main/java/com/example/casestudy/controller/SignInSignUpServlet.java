package com.example.casestudy.controller;

import com.example.casestudy.Verified.VerifiedCustomer.VerifiedCustomer;
import com.example.casestudy.model.Customer;
import com.example.casestudy.model.Pet;
import com.example.casestudy.model.PetSpecial;
import com.example.casestudy.service.CustomerManager;
import com.example.casestudy.service.PetManager;
import com.example.casestudy.service.PetSpecialManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "SignInSignUpServlet", value = "/LoginServlet")
public class SignInSignUpServlet extends HttpServlet {
    CustomerManager customerManager = new CustomerManager();
    VerifiedCustomer verifiedCustomer = new VerifiedCustomer();
    PetManager petManager = new PetManager();
    PetSpecialManager petSpecialManager = new PetSpecialManager();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "signUp":
                String messageSignUp = "signUp";
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("SignIN_SignUp.jsp");
                request.setAttribute("messageSignUp", messageSignUp);
                requestDispatcher.forward(request,response);
                break;
            case "logOut":
                HttpSession session = request.getSession();
                session.invalidate();
                response.sendRedirect("SignIN_SignUp.jsp");
                break;
            case "displayAdmin":
                displayAdmin(request, response);
                break;
            case "displayCustomer":
                displayCustomer(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "signIn":
                signIn(request, response);
                break;
            case "signUp":
                signUp(request, response);
                break;
        }
    }

    public void signIn(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String userName = request.getParameter("usrName");
        String password = request.getParameter("psw");
        if (userName.equals("admin") && password.equals("admin")) {
            response.sendRedirect("/LoginServlet?action=displayAdmin");
        } else if (customerManager.checkCustomerExist(userName, password) != null) {
            Customer customer = customerManager.checkCustomerExist(userName, password);
            HttpSession session = request.getSession();
            session.setAttribute("customer", customer);
            response.sendRedirect("/LoginServlet?action=displayCustomer");
        } else {
            String failMassage = "Username or password is incorrect!";
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("SignIN_SignUp.jsp");
            request.setAttribute("userName",userName);
            request.setAttribute("password",password);
            request.setAttribute("failMassage", failMassage);
            requestDispatcher.forward(request,response);
        }
    }

    public void signUp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("username");
        String password = request.getParameter("psw");
        String passwordRepeat = request.getParameter("psw-repeat");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = new Customer(userName, password, phone, email, address);
        boolean check = true;
        if (customerManager.checkUserNameExist(userName)) {
            String userNameMessage = "Tên đăng nhập đã tồn tại!";
            request.setAttribute("userNameMessage", userNameMessage);
            check = false;
        }
        if (verifiedCustomer.verifiedPassword(password)) {
            if (!password.equals(passwordRepeat)) {
                String passwordRepeatMessage = "Mật khẩu nhập lại không đúng!";
                request.setAttribute("passwordRepeatMessage", passwordRepeatMessage);
                check = false;
            }
        } else {
            String passwordMessage = "Mật khẩu không hợp lệ!";
            request.setAttribute("passwordMessage", passwordMessage);
            check = false;
        }
        if (!verifiedCustomer.verifiedPhoneNumber(phone)) {
            String phoneMessage = "Số điện thoại không hợp lệ!";
            request.setAttribute("phoneMessage", phoneMessage);
            check = false;
        }
        if (!verifiedCustomer.verifiedEmail(email)) {
            String emailMessage = "Email không hợp lệ!";
            request.setAttribute("emailMessage", emailMessage);
            check = false;
        }
        if (check) {
            customerManager.create(customer);
            JOptionPane.showMessageDialog(null,"Tạo tài khoản thành công!","Đăng kí tài khoản",
                    JOptionPane.INFORMATION_MESSAGE);
            response.sendRedirect("SignIN_SignUp.jsp");
        } else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("SignIN_SignUp.jsp");
            request.setAttribute("c", customer);
            request.setAttribute("passwordRepeat", passwordRepeat);
            String messageSignUp = "signUpAgain";
            request.setAttribute("messageSignUp", messageSignUp);
            requestDispatcher.forward(request,response);
        }
    }

    public void displayAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ArrayList<Pet> pets = petManager.findAll();
        ArrayList<PetSpecial> petSpecials = petSpecialManager.findAll();
        String admin = "admin";
        session.setAttribute("pets", pets);
        session.setAttribute("admin", admin);
        session.setAttribute("petSpecials", petSpecials);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("homePage.jsp");
        requestDispatcher.forward(request,response);
    }
    public void displayCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Pet> pets = petManager.findAll();
        ArrayList<PetSpecial> petSpecials = petSpecialManager.findAll();
        HttpSession session = request.getSession();
        session.setAttribute("pets", pets);
        session.setAttribute("petSpecials", petSpecials);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("homePage.jsp");
        requestDispatcher.forward(request,response);
    }
}
