package com.example.casestudy.DAO;

import com.example.casestudy.connection.MyConnection;
import com.example.casestudy.model.Customer;
import com.example.casestudy.model.Order;
import com.example.casestudy.service.CustomerManager;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class OrderRepository implements CRUDRepository<Order>{
    private final String CREATE_ORDER = "insert into ordercustomer(customerId, dateCreateOrder, orderStatus) values (?,?,?)";
    private final String SELECT_ALL_ORDER = "CALL findAllOrder();";
    private final String DELETE_ORDER_BY_ID = "call deleteOrderById(?)";
    private final String SELECT_ORDER_NEW = "select * from ordercustomer where id = (select max(id) from ordercustomer)";

    private final MyConnection myConnection = new MyConnection();
    CustomerManager customerManager = new CustomerManager();
    @Override
    public ArrayList<Order> findAll() {
        ArrayList<Order> orders = new ArrayList<>();
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ORDER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                int idCustomer = resultSet.getInt(2);
                Date date = resultSet.getDate("dateCreateOrder");
                String status = resultSet.getString("orderStatus");
                int totalOrder = Integer.parseInt(resultSet.getString("total"));
                Customer customer = customerManager.findById(idCustomer);
                LocalDate dateCreateOrder = LocalDate.parse(date.toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                Order order = new Order(id,customer,dateCreateOrder,status,totalOrder);
                orders.add(order);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return orders;
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
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ORDER_BY_ID);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public Order findOrderNew() {
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ORDER_NEW);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int idCustomer = resultSet.getInt("customerId");
                Date date = resultSet.getDate("dateCreateOrder");
                String status = resultSet.getString("orderStatus");
                Customer customer = customerManager.findById(idCustomer);
                LocalDate dateCreateOrder = LocalDate.parse(date.toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                Order order = new Order(id,customer,dateCreateOrder,status);
                return order;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}
