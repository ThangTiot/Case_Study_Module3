package com.example.casestudy.model;

public class OrderDetail {
    private Pet pet;
    private Order order;

    public OrderDetail() {
    }

    public OrderDetail(Pet pet, Order order) {
        this.pet = pet;
        this.order = order;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
