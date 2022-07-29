package com.example.casestudy.DAO;

import com.example.casestudy.connection.MyConnection;
import com.example.casestudy.model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerRepository implements CRUDRepository<Customer>{
    private final MyConnection myConnection = new MyConnection();
    private final String SELECT_ALL_CUSTOMER = "select * from customer";
    private final String CREATE_CUSTOMER = "insert into customer (username,pass,phone,mail,address) values (?,?,?,?,?)";

    @Override
    public ArrayList<Customer> findAll() {
        ArrayList<Customer> customers = new ArrayList<>();
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String userName = resultSet.getString("userName");
                String pass = resultSet.getString("pass");
                String phone = resultSet.getString("phone");
                String mail = resultSet.getString("mail");
                String address = resultSet.getString("address");
                Customer customer = new Customer(id, userName, pass, phone, mail, address);
                customers.add(customer);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return customers;
    }

    @Override
    public void create(Customer customer) {
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_CUSTOMER);
            preparedStatement.setString(1,customer.getUsername());
            preparedStatement.setString(2,customer.getPass());
            preparedStatement.setString(3,customer.getPhone());
            preparedStatement.setString(4,customer.getMail());
            preparedStatement.setString(5,customer.getAddress());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void deleteById(int id) {

    }


//    public ArrayList<Customer> findAll(){
//        ArrayList<Customer> customers = new ArrayList<>();
//        try {
//            Connection connection = myConnection.getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                int id = resultSet.getInt("id");
//                String userName = resultSet.getString("userName");
//                String pass = resultSet.getString("pass");
//                String phone = resultSet.getString("phone");
//                String mail = resultSet.getString("mail");
//                String address = resultSet.getString("address");
//                Customer customer = new Customer(id, userName, pass, phone, mail, address);
//                customers.add(customer);
//            }
//        } catch (SQLException e) {
//            System.err.println(e.getMessage());
//        }
//        return customers;
//    }
//
//    public void creat(Customer customer) {
//        try {
//            Connection connection = myConnection.getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_CUSTOMER);
//            preparedStatement.setString(1,customer.getUsername());
//            preparedStatement.setString(2,customer.getPass());
//            preparedStatement.setString(3,customer.getPhone());
//            preparedStatement.setString(4,customer.getMail());
//            preparedStatement.setString(5,customer.getAddress());
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            System.err.println(e.getMessage());
//        }
//    }
}
