package com.example.casestudy.model;

import java.text.NumberFormat;
import java.util.Locale;

public class Pet {
    private int id;
    private String name;
    private String age;
    private int price;
    private PetSpecial special;
    private String image;
    private String status = "Available";
    private int check = 1;

    public Pet() {
    }

    public Pet(String name, String age, int price, PetSpecial special, String image) {
        this.name = name;
        this.age = age;
        this.price = price;
        this.special = special;
        this.image = image;
    }

    public Pet(int id, String name, String age, int price, PetSpecial special, String image, String status) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.price = price;
        this.special = special;
        this.image = image;
        this.status = status;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getPrice() {
        return price;
    }


    public void setPrice(int price) {
        this.price = price;
    }

    public PetSpecial getSpecial() {
        return special;
    }

    public void setSpecial(PetSpecial special) {
        this.special = special;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCheck() {
        return check;
    }

    public void setCheck(int check) {
        this.check = check;
    }

    public String getPriceString() {
        int a = price;
        Locale locale = new Locale("vi", "VN");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
        String accountBalance = numberFormat.format(a);
        return accountBalance;
    }
}
