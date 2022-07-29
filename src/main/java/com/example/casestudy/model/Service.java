package com.example.casestudy.model;

public class Service {
    private int id;
    private String serviceName;
    private int price;
    private int serviceDay;

    public Service() {
    }

    public Service(String serviceName, int price, int serviceDay) {
        this.serviceName = serviceName;
        this.price = price;
        this.serviceDay = serviceDay;
    }

    public Service(int id, String serviceName, int price, int serviceDay) {
        this.id = id;
        this.serviceName = serviceName;
        this.price = price;
        this.serviceDay = serviceDay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getServiceDay() {
        return serviceDay;
    }

    public void setServiceDay(int serviceDay) {
        this.serviceDay = serviceDay;
    }
}
