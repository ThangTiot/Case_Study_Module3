package com.example.casestudy.service;

import com.example.casestudy.DAO.PetRepository;
import com.example.casestudy.model.Pet;
import com.example.casestudy.model.PetSpecial;

import java.util.ArrayList;

public class PetManager implements CRUDService<Pet>{
    PetRepository petRepository = new PetRepository();
    @Override
    public void create(Pet pet) {
        petRepository.creat(pet);
    }

    @Override
    public ArrayList<Pet> findAll() {
        return petRepository.findAll();
    }

    @Override
    public Pet findById(int id) {
        ArrayList<Pet> pets = findAll();
        for (Pet pet : pets) {
            if (pet.getId() == id) {
                return pet;
            }
        }
        return null;
    }

    @Override
    public void update(Pet pet) {
        petRepository.update(pet);
    }

    @Override
    public void deleteById(int id) {
        petRepository.deleteById(id);
    }
}
