package com.example.casestudy.DAO;

import com.example.casestudy.connection.MyConnection;
import com.example.casestudy.model.Customer;
import com.example.casestudy.model.OrderService;
import com.example.casestudy.service.CustomerManager;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class OrderServiceRepository implements CRUDRepository<OrderService> {
    static MyConnection myConnection = new MyConnection();
    static CustomerManager customerManager = new CustomerManager();

    private static final String SELECT_ALL_ORDERSERVICE = "select * from ordercustomerservice";
    private final String CREATE_ORDERSERVICE = "insert into ordercustomerservice (customerId,dateCreateService,orderServiceStatus) values (?,?,?)";
    private final String DELETE_ORDERSERVICE_BY_ID = "delete from ordercustomerservice where id = ?";
    private static final String UPDATE_ORDERSERVICE_BY_ID = "update ordercustomerservice set customerId = ?,dateCreateService = ?, orderServiceStatus = ? where id = ?";

    @Override
    public ArrayList<OrderService> findAll() {
        ArrayList<OrderService> orderServices = new ArrayList<>();
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ORDERSERVICE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int customerId = resultSet.getInt("customer_id");
                Date dateCreateService = resultSet.getDate("dateCreateService");
                String status = resultSet.getString("orderServiceStatus");
                Customer customer = customerManager.findById(customerId);
                OrderService orderService = new OrderService(id, customer, LocalDate.parse(dateCreateService.toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd")), status);
                orderServices.add(orderService);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return orderServices;
    }

    @Override
    public void create(OrderService orderService) {
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_ORDERSERVICE);
            preparedStatement.setInt(1, orderService.getCustomer().getId());
            preparedStatement.setDate(2, Date.valueOf(orderService.getDateCreateService()));
            preparedStatement.setString(3, orderService.getStatus());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void deleteById(int id) {
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ORDERSERVICE_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void update(OrderService orderService) {
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ORDERSERVICE_BY_ID);
            preparedStatement.setInt(1, orderService.getCustomer().getId());
            preparedStatement.setDate(2, Date.valueOf(orderService.getDateCreateService()));
            preparedStatement.setString(3, orderService.getStatus());
            preparedStatement.setInt(4, orderService.getId());
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}