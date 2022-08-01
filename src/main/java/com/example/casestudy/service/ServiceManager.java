package com.example.casestudy.service;

import com.example.casestudy.DAO.ServiceRepository;
import com.example.casestudy.model.Service;

import java.sql.SQLException;
import java.util.ArrayList;

public class ServiceManager implements CRUDService<Service> {
    ServiceRepository serviceRepository =new ServiceRepository();
    @Override
    public void create(Service service){
        serviceRepository.create(service);
    }

    @Override
    public ArrayList<Service> findAll() {
        return  serviceRepository.findAll();
    }

    @Override
    public Service findById(int id) {
        ArrayList<Service> services = findAll();
        for(Service service : services){
            if(service.getId() == id){
                return service;
            }
        }
        return null;
    }

    @Override
    public void update(Service service) {
        serviceRepository.update(service);
    }

    @Override
    public void deleteById(int id) {
        serviceRepository.deleteById(id);
    }
}