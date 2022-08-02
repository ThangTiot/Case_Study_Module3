package com.example.casestudy.service;

import com.example.casestudy.DAO.PetRepository;
import com.example.casestudy.model.Customer;
import com.example.casestudy.model.Pet;
import com.example.casestudy.model.PetSpecial;

import java.util.ArrayList;

public class PetManager implements CRUDService<Pet>{
    PetRepository petRepository = new PetRepository();
    @Override
    public void create(Pet pet) {
        petRepository.create(pet);
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
    public boolean checkPetNameExist(String petName) {
        ArrayList<Pet> pets = findAll();
        for (Pet pet : pets) {
            if (pet.getName().equals(petName)) {
                return true;
            }
        }
        return false;
    }

    public void updatePetAfterBuy(Pet pet) {
        petRepository.updatePetAfterBuy(pet);
    }

    public ArrayList<Pet> findPetBySpecies(int petSpecialId) {
        return petRepository.findPetBySpecies(petSpecialId);
    }
}
