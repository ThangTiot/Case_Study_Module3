package com.example.casestudy.model;

import java.util.Date;

public class OrderService {
    private int id;
    private Customer customer;
    private Date dateCreateService;
    private String status = "Chưa thanh toán";

    public OrderService() {
    }

    public OrderService(Customer customer, Date dateCreateService) {
        this.customer = customer;
        this.dateCreateService = dateCreateService;
    }

    public OrderService(int id, Customer customer, Date dateCreateService, String status) {
        this.id = id;
        this.customer = customer;
        this.dateCreateService = dateCreateService;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getDateCreateService() {
        return dateCreateService;
    }

    public void setDateCreateService(Date dateCreateService) {
        this.dateCreateService = dateCreateService;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
