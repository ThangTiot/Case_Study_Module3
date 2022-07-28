package com.example.casestudy.model;

public class OrderServiceDetail {
    private Service service;
    private OrderService orderService;
    private int quantity;

    public OrderServiceDetail() {
    }

    public OrderServiceDetail(Service service, OrderService orderService, int quantity) {
        this.service = service;
        this.orderService = orderService;
        this.quantity = quantity;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public OrderService getOrderService() {
        return orderService;
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
