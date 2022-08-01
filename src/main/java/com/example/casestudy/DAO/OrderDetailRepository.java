package com.example.casestudy.DAO;

import com.example.casestudy.connection.MyConnection;
import com.example.casestudy.model.OrderDetail;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailRepository implements CRUDRepository<OrderDetail>{
    private final String CREATE_ORDER_DETAIL = "insert into ordercustomerdetail values (?,?)";
    MyConnection myConnection = new MyConnection();

    @Override
    public ArrayList<OrderDetail> findAll() {
        return null;
    }

    @Override
    public void create(OrderDetail orderDetail) {
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_ORDER_DETAIL);
            preparedStatement.setInt(1,orderDetail.getPet().getId());
            preparedStatement.setInt(2,orderDetail.getOrder().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void deleteById(int id) {

    }
}
