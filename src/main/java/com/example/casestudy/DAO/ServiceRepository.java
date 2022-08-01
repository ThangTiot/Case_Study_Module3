package com.example.casestudy.DAO;

import com.example.casestudy.connection.MyConnection;
import com.example.casestudy.model.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServiceRepository implements CRUDRepository<Service> {
    private final MyConnection myConnection = new MyConnection();
    private final String SELECT_ALL_SERVICE = "select * from service";
    private final String CREATE_SERVICE = "insert into service (serviceName,price,serviceDay) value (?,?,?)";
    private final String DELETE_SERVICE_BY_ID = "delete from service where id = ?";
    private final String UPDATE_SERVICE_BY_ID = "update service set serviceName = ? , price = ? , serviceDay = ?";

    @Override
    public ArrayList<Service> findAll() {
        ArrayList<Service> services = new ArrayList<>();
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SERVICE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("serviceName");
                int price = resultSet.getInt("price");
                int serviceDay = resultSet.getInt("serviceDay");
                services.add(new Service(id, name, price, serviceDay));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return services;
    }

    @Override
    public void create(Service service) {

        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_SERVICE );
            preparedStatement.setString(1,service.getServiceName());
            preparedStatement.setInt(2,service.getPrice());
            preparedStatement.setInt(3,service.getServiceDay());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }

    @Override
    public void deleteById(int id) {
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SERVICE_BY_ID);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }


    public void update(Service service){
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SERVICE_BY_ID);
            preparedStatement.setString(1,service.getServiceName());
            preparedStatement.setInt(2,service.getPrice());
            preparedStatement.setInt(3,service.getServiceDay());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}