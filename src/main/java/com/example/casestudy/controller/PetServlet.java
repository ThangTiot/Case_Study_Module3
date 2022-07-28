package com.example.casestudy.controller;

import com.example.casestudy.Verified.VerifiedPet.VerifiedPet;
import com.example.casestudy.model.Pet;
import com.example.casestudy.model.PetSpecial;
import com.example.casestudy.service.PetSpecialManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "PetServlet", value = "/PetServlet")
public class PetServlet extends HttpServlet {
    VerifiedPet verifiedPet = new VerifiedPet();
    PetSpecialManager petSpecialManager = new PetSpecialManager();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "createPetGet":
                createPetGet(response);
                break;
            case "deletePetSpecialGet":
                deletePetSpecialGet(request,response);
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "createPetPost":
                createPetPost(request,response);
                break;
            case "creatPetSpecialPost":
                creatPetSpecialPost(request,response);
                break;
        }
    }

    public void createPetGet(HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("pet/createPet.jsp");
    }

    public void createPetPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            String petName = request.getParameter("petName");
            String age = request.getParameter("age");
            int price = Integer.parseInt(request.getParameter("price"));
            int specialId = Integer.parseInt(request.getParameter("species"));
            String image = request.getParameter("image");
            PetSpecial special = petSpecialManager.findById(specialId);
            Pet pet = new Pet(petName, age, price, special, image);
        } catch (Exception e) {
            String priceMessage = "Giá không hợp lệ!";
            request.setAttribute("priceMessage",priceMessage);
        }
//        if (verifiedPet.verifiedAge())
    }

    public void creatPetSpecialPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String special = request.getParameter("special");
        PetSpecial petSpecial = new PetSpecial(special);
        petSpecialManager.create(petSpecial);
        response.sendRedirect("pet/createPet.jsp");
    }

    public void deletePetSpecialGet(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        petSpecialManager.deleteById(id);
    }
}
