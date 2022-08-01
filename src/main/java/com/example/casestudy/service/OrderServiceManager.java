package com.example.casestudy.service;

import com.example.casestudy.DAO.CRUDRepository;
import com.example.casestudy.DAO.OrderServiceRepository;
import com.example.casestudy.model.OrderService;

import java.util.ArrayList;

public class OrderServiceManager implements CRUDService<OrderService> {
    public OrderServiceRepository orderServiceRepository = new OrderServiceRepository();

    @Override
    public void create(OrderService orderService) {
        orderServiceRepository.create(orderService);
    }

    @Override
    public ArrayList<OrderService> findAll() {
        return orderServiceRepository.findAll();
    }

    @Override
    public OrderService findById(int id) {
        ArrayList<OrderService> orderServices = findAll();
        for (OrderService orderService : orderServices) {
            if (orderService.getId() == id) {
                return orderService;
            }
        }
        return null;
    }

    @Override
    public void update(OrderService orderService) {
        OrderServiceRepository.update(orderService);
    }

    @Override
    public void deleteById(int id) {
        orderServiceRepository.deleteById(id);
    }
}