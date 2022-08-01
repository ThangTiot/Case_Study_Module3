package com.example.casestudy.service;

import com.example.casestudy.DAO.OrderDetailRepository;
import com.example.casestudy.connection.MyConnection;
import com.example.casestudy.model.OrderDetail;

import java.util.ArrayList;

public class OrderDetailManager implements CRUDService<OrderDetail> {
    OrderDetailRepository orderDetailRepository = new OrderDetailRepository();

    @Override
    public void create(OrderDetail orderDetail) {
        orderDetailRepository.create(orderDetail);
    }

    @Override
    public ArrayList<OrderDetail> findAll() {
        return null;
    }

    @Override
    public OrderDetail findById(int id) {
        return null;
    }

    @Override
    public void update(OrderDetail orderDetail) {

    }

    @Override
    public void deleteById(int id) {

    }
}
