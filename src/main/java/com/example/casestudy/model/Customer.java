package com.example.casestudy.model;

public class Customer {
    private int id;
    private String username;
    private String pass;
    private String phone;
    private String mail;
    private String address;

    public Customer() {
    }

    public Customer(String username, String pass, String phone, String mail, String address) {
        this.username = username;
        this.pass = pass;
        this.phone = phone;
        this.mail = mail;
        this.address = address;
    }

    public Customer(int id, String username, String pass, String phone, String mail, String address) {
        this.id = id;
        this.username = username;
        this.pass = pass;
        this.phone = phone;
        this.mail = mail;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
