package com.example.casestudy.DAO;

import com.example.casestudy.connection.MyConnection;
import com.example.casestudy.model.PetSpecial;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PetSpecialRepository implements CRUDRepository<PetSpecial>{
    MyConnection myConnection = new MyConnection();
    private final String SELECT_ALL_SPECIAL = "select * from petspecial";
    private final String CREATE_SPECIAL = "insert into petspecial(special, checkDelete) values (?,?)";
    private final String DELETE_SPECIAL_BY_ID = "update petspecial set checkDelete = 0 where id = ?";

    @Override
    public ArrayList<PetSpecial> findAll() {
        ArrayList<PetSpecial> specials = new ArrayList<>();
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SPECIAL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String special = resultSet.getString("special");
                int checkDelete = resultSet.getInt("checkDelete");
                if (checkDelete == 1) {
                    PetSpecial petSpecial = new PetSpecial(id, special);
                    specials.add(petSpecial);
                }
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return specials;
    }

    @Override
    public void create(PetSpecial petSpecial) {
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_SPECIAL);
            preparedStatement.setString(1,petSpecial.getName());
            preparedStatement.setInt(2,petSpecial.getCheckDelete());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void deleteById(int id) {
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SPECIAL_BY_ID);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
