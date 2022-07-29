package com.example.casestudy.service;

import com.example.casestudy.DAO.PetSpecialRepository;
import com.example.casestudy.model.PetSpecial;

import java.util.ArrayList;

public class PetSpecialManager implements CRUDService<PetSpecial>{
    PetSpecialRepository petSpecialRepository = new PetSpecialRepository();
    @Override
    public void create(PetSpecial petSpecial) {
        petSpecialRepository.create(petSpecial);
    }

    @Override
    public ArrayList<PetSpecial> findAll() {
        return petSpecialRepository.findAll();
    }
    @Override
    public PetSpecial findById(int id) {
        ArrayList<PetSpecial> specials = findAll();
        for (PetSpecial petSpecial : specials) {
            if (petSpecial.getId() == id) {
                return petSpecial;
            }
        }
        return null;
    }

    @Override
    public void update(PetSpecial petSpecial) {

    }

    @Override
    public void deleteById(int id) {
        petSpecialRepository.deleteById(id);
    }
}
