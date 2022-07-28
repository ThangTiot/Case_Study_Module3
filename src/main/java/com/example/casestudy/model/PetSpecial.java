package com.example.casestudy.model;

public class PetSpecial {
    private int id;
    private String name;

    public PetSpecial() {
    }

    public PetSpecial(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
