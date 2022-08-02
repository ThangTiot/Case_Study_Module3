package com.example.casestudy.model;

public class PetSpecial {
    private int id;
    private String specialName;
    private int checkDelete = 1;

    public PetSpecial() {
    }

    public PetSpecial(String specialName) {
        this.specialName = specialName;
    }

    public PetSpecial(int id, String specialName) {
        this.id = id;
        this.specialName = specialName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return specialName;
    }

    public void setName(String name) {
        this.specialName = name;
    }

    public int getCheckDelete() {
        return checkDelete;
    }

    public void setCheckDelete(int checkDelete) {
        this.checkDelete = checkDelete;
    }
}
