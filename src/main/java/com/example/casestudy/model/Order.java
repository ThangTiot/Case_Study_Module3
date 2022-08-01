package com.example.casestudy.model;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

public class Order {
    private int id;
    private Customer customer;
    private LocalDate dateCreateOrder = LocalDate.now();
    private String status = "Chưa thanh toán";
    private int totalOrder;

    public Order() {
    }

    public Order(Customer customer) {
        this.customer = customer;
    }

    public Order(int id, Customer customer, LocalDate dateCreateOrder, String status, int totalOrder) {
        this.id = id;
        this.customer = customer;
        this.dateCreateOrder = dateCreateOrder;
        this.status = status;
        this.totalOrder = totalOrder;
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

    public LocalDate getDateCreateOrder() {
        return dateCreateOrder;
    }

    public void setDateCreateOrder(LocalDate dateCreateOrder) {
        this.dateCreateOrder = dateCreateOrder;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalOrder() {
        return totalOrder;
    }

    public void setTotalOrder(int totalOrder) {
        this.totalOrder = totalOrder;
    }
    public String getTotalString() {
        int a = totalOrder;
        Locale locale = new Locale("vi", "VN");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
        String accountBalance = numberFormat.format(a);
        return accountBalance;
    }
}
