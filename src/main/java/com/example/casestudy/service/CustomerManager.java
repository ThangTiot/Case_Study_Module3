package com.example.casestudy.service;

import com.example.casestudy.DAO.CustomerRepository;
import com.example.casestudy.model.Customer;

import java.util.ArrayList;

public class CustomerManager implements CRUDService<Customer>{
    private CustomerRepository customerRepository = new CustomerRepository();

    @Override
    public void create(Customer customer) {
        customerRepository.create(customer);
    }

    @Override
    public ArrayList<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public void update(Customer customer) {

    }

    @Override
    public void deleteById(int id) {

    }

    public Customer checkCustomerExist(String userName, String pass) {
        ArrayList<Customer> customers = findAll();
        for (Customer customer : customers) {
            if (customer.getUsername().equals(userName) && customer.getPass().equals(pass)) {
                return customer;
            }
        }
        return null;
    }

    public boolean checkUserNameExist(String userName) {
        ArrayList<Customer> customers = findAll();
        for (Customer customer : customers) {
            if (customer.getUsername().equals(userName)) {
                return true;
            }
        }
        return false;
    }
}
