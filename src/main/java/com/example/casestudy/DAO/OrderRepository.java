package com.example.casestudy.DAO;

import com.example.casestudy.connection.MyConnection;
import com.example.casestudy.model.Order;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderRepository implements CRUDRepository<Order>{
    private final String CREATE_ORDER = "insert into ordercustomer(customerId, dateCreateOrder, orderStatus) values (?,?,?)";
    private final MyConnection myConnection = new MyConnection();
    @Override
    public ArrayList<Order> findAll() {
        return null;
    }

    @Override
    public void create(Order order) {
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_ORDER);
            preparedStatement.setInt(1,order.getCustomer().getId());
            preparedStatement.setDate(2, Date.valueOf(order.getDateCreateOrder()));
            preparedStatement.setString(3,order.getStatus());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void deleteById(int id) {

    }
}
