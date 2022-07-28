package com.example.casestudy.controller;

import com.example.casestudy.Verified.VerifiedCustomer.VerifiedCustomer;
import com.example.casestudy.model.Customer;
import com.example.casestudy.service.CustomerManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class SignInSignUpServlet extends HttpServlet {
    CustomerManager customerManager = new CustomerManager();
    VerifiedCustomer verifiedCustomer = new VerifiedCustomer();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String messageSignUp = "signUp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("SignIN_SignUp.jsp");
        request.setAttribute("messageSignUp", messageSignUp);
        requestDispatcher.forward(request,response);
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
            default:
                response.sendRedirect("home.jsp");
                break;
        }
    }

    public void signIn(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String userName = request.getParameter("usrName");
        String password = request.getParameter("psw");
        if (userName.equals("admin") && password.equals("admin")) {
            response.sendRedirect("home.jsp");
        } else if (customerManager.checkCustomerExist(userName, password)) {
            response.sendRedirect("homeCustomer.jsp");
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
            response.sendRedirect("homeCustomer.jsp");
        } else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("SignIN_SignUp.jsp");
            request.setAttribute("c", customer);
            request.setAttribute("passwordRepeat", passwordRepeat);
            String messageSignUp = "signUpAgain";
            request.setAttribute("messageSignUp", messageSignUp);
            requestDispatcher.forward(request,response);
        }
    }
}
