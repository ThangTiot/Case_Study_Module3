package com.example.casestudy.DAO;

import com.example.casestudy.connection.MyConnection;
import com.example.casestudy.model.Pet;
import com.example.casestudy.model.PetSpecial;
import com.example.casestudy.service.PetSpecialManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PetRepository implements CRUDRepository<Pet>{
    MyConnection myConnection = new MyConnection();
    PetSpecialManager petSpecialManager = new PetSpecialManager();
    private final String SELECT_ALL_PET = "select * from pet";
    private final String CREATE_PET = "insert into pet(petName, age, price, petSpecialId, image, petStatus) values (?,?,?,?,?,?)";
    private final String DELETE_PET_BY_ID = "delete from pet where id = ?";
    private final String UPDATE_PET_BT_ID = "update pet set petName = ? , age = ? , price = ? , petSpecialId = ? , " +
            "image = ? , petStatus = ? where id = ?";

    @Override
    public ArrayList<Pet> findAll() {
        ArrayList<Pet> petList = new ArrayList<>();
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PET);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String petName = resultSet.getString("petName");
                String age = resultSet.getString("age");
                int price = resultSet.getInt("price");
                int petSpecialId = resultSet.getInt("petSpecialId");
                String image = resultSet.getString("image");
                String petStatus = resultSet.getString("petStatus");
                PetSpecial special = petSpecialManager.findById(petSpecialId);
                Pet pet = new Pet(id, petName, age, price, special, image, petStatus);
                petList.add(pet);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return petList;
    }

    @Override
    public void create(Pet pet) {
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_PET);
            preparedStatement.setString(1,pet.getName());
            preparedStatement.setString(2,pet.getAge());
            preparedStatement.setInt(3,pet.getPrice());
            preparedStatement.setInt(4,pet.getspecial().getId());
            preparedStatement.setString(5,pet.getImage());
            preparedStatement.setString(6,pet.getStatus());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void deleteById(int id) {
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PET_BY_ID);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void update(Pet pet) {
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PET_BT_ID);
            preparedStatement.setString(1,pet.getName());
            preparedStatement.setString(2,pet.getAge());
            preparedStatement.setInt(3,pet.getPrice());
            preparedStatement.setInt(4,pet.getspecial().getId());
            preparedStatement.setString(5,pet.getImage());
            preparedStatement.setString(6,pet.getStatus());
            preparedStatement.setInt(7,pet.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
