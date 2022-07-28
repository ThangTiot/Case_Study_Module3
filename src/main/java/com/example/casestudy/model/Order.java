package com.example.casestudy.model;

import java.util.Date;

public class Order {
    private int id;
    private Customer customer;
    private Date dateCreateOrder;
    private String status = "Chưa thanh toán";

    public Order() {
    }

    public Order(Customer customer, Date dateCreateOrder, String status) {
        this.customer = customer;
        this.dateCreateOrder = dateCreateOrder;
        this.status = status;
    }

    public Order(int id, Customer customer, Date dateCreateOrder, String status) {
        this.id = id;
        this.customer = customer;
        this.dateCreateOrder = dateCreateOrder;
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

    public Date getDateCreateOrder() {
        return dateCreateOrder;
    }

    public void setDateCreateOrder(Date dateCreateOrder) {
        this.dateCreateOrder = dateCreateOrder;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
