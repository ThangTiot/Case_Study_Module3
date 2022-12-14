package com.example.casestudy.service;

import com.example.casestudy.DAO.OrderRepository;
import com.example.casestudy.model.Customer;
import com.example.casestudy.model.Order;
import com.example.casestudy.model.Pet;

import java.util.ArrayList;

public class OrderManager implements CRUDService<Order>{
    OrderRepository orderRepository = new OrderRepository();
    @Override
    public void create(Order order) {
        orderRepository.create(order);
    }

    public String totalPriceTemp(ArrayList<Pet> pets) {
        Order order = new Order();
        int sum = 0;
        for (Pet pet : pets) {
            sum += pet.getPrice();
        }
        order.setTotalOrder(sum);
        return order.getTotalString();
    }

    @Override
    public ArrayList<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order findById(int id) {
        return null;
    }

    @Override
    public void update(Order order) {

    }

    @Override
    public void deleteById(int id) {
        orderRepository.deleteById(id);
    }

    public Order findOrderNew() {
        return orderRepository.findOrderNew();
    }
}
