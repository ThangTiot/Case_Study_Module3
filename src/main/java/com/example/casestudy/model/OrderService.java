package com.example.casestudy.model;

import java.time.LocalDate;
import java.util.Date;

public class OrderService {
    private int id;
    private Customer customer;
    private LocalDate dateCreateService = LocalDate.now();
    private String status = "Chưa thanh toán";

    public OrderService() {
    }

    public OrderService(Customer customer) {
        this.customer = customer;
    }

    public OrderService(int id, Customer customer, LocalDate dateCreateService, String status) {
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

    public LocalDate getDateCreateService() {
        return dateCreateService;
    }

    public void setDateCreateService(LocalDate dateCreateService) {
        this.dateCreateService = dateCreateService;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
