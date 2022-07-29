package com.example.casestudy.controller;

import com.example.casestudy.Verified.VerifiedPet.VerifiedPet;
import com.example.casestudy.model.Pet;
import com.example.casestudy.model.PetSpecial;
import com.example.casestudy.service.PetManager;
import com.example.casestudy.service.PetSpecialManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "PetServlet", value = "/PetServlet")
public class PetServlet extends HttpServlet {
    VerifiedPet verifiedPet = new VerifiedPet();
    PetSpecialManager petSpecialManager = new PetSpecialManager();
    PetManager petManager = new PetManager();
    SignInSignUpServlet signInSignUpServlet = new SignInSignUpServlet();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        switch (action) {
            case "createPetGet":
                createPetGet(request,response);
                break;
            case "deletePetSpecialGet":
                deletePetSpecialGet(request);
                break;
            case "updatePetGet":
                updatePetGet(request,response);
                break;
            case "deletePetGet":
                deletePetGet(request);
                break;
            default:
                signInSignUpServlet.displayAdmin(request,response);
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        switch (action) {
            case "createPetPost":
                createPetPost(request,response);
                break;
            case "creatPetSpecialPost":
                creatPetSpecialPost(request,response);
                break;
            case "updatePetPost":
                updatePetPost(request,response);
                break;
        }
    }

    public void createPetGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("pet/createPet.jsp");
        ArrayList<PetSpecial> petSpecials = petSpecialManager.findAll();
        request.setAttribute("petSpecials", petSpecials);
        requestDispatcher.forward(request, response);
    }

    public void createPetPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String petName = request.getParameter("petName");
            String age = request.getParameter("age");
            int price = Integer.parseInt(request.getParameter("price"));
            int specialId = Integer.parseInt(request.getParameter("specialId"));
            Part part = (Part) request.getParts();
            String image = getFileName(part);
            PetSpecial special = petSpecialManager.findById(specialId);
            Pet pet = new Pet(petName, age, price, special, image);
            boolean check = true;
            if (petManager.checkPetNameExist(petName)) {
                String petNameFailMessage = "Tên đã tồn tại!";
                request.setAttribute("petNameFailMessage", petNameFailMessage);
                check = false;
            }
            if (!verifiedPet.verifiedAge(age)) {
                String ageFailMessage = "Tuổi không hợp lệ!";
                request.setAttribute("ageFailMessage", ageFailMessage);
            }
            if (check) {
                petManager.create(pet);
                response.sendRedirect("/PetServlet?action=");
            } else {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("pet/createPet.jsp");
                request.setAttribute("p", pet);
                requestDispatcher.forward(request, response);
            }
        } catch (Exception e) {
            String priceFailMessage = "Giá không hợp lệ!";
            request.setAttribute("priceFailMessage",priceFailMessage);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("pet/createPet.jsp");
            requestDispatcher.forward(request,response);
        }
    }
    private String getFileName(Part part) {
        String content = part.getHeader("content-disposition");
        String[] contents = content.split(";");
        for (String s : contents) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() -1);
            }
        }
        return "";
    }

    public void creatPetSpecialPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String special = request.getParameter("special");
        PetSpecial petSpecial = new PetSpecial(special);
        petSpecialManager.create(petSpecial);
        response.sendRedirect("pet/createPet.jsp");
    }

    public void deletePetSpecialGet(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        petSpecialManager.deleteById(id);
    }

    public void updatePetGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Pet pet = petManager.findById(id);
        ArrayList<PetSpecial> petSpecialList = petSpecialManager.findAll();
        request.setAttribute("pet",pet);
        request.setAttribute("petSpecialList",petSpecialList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("pet/updatePet.jsp");
        requestDispatcher.forward(request,response);
    }
    public void updatePetPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String petName = request.getParameter("petName");
            String age = request.getParameter("age");
            int price = Integer.parseInt(request.getParameter("price"));
            int specialId = Integer.parseInt(request.getParameter("specialId"));
            String image = request.getParameter("image");
            String status = request.getParameter("status");
            PetSpecial special = petSpecialManager.findById(specialId);
            Pet pet = new Pet(id, petName, age, price, special, image, status);
            if (verifiedPet.verifiedAge(age)) {
                petManager.update(pet);
            } else {
                String ageFailMessage = "Tuổi không hợp lệ!";
                request.setAttribute("ageFailMessage", ageFailMessage);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("pet/updatePet.jsp");
                requestDispatcher.forward(request, response);
            }
        } catch (Exception e) {
            String priceFailMessage = "Giá không hợp lệ!";
            request.setAttribute("priceFailMessage",priceFailMessage);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("pet/updatePet.jsp");
            requestDispatcher.forward(request,response);
        }
    }

    public void deletePetGet(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        petManager.deleteById(id);
    }


}
