package com.example.casestudy.service;

import java.util.ArrayList;

public interface CRUDService<E> {
    void create(E e);
    ArrayList<E> findAll();

    E findById(int id);
    void update(E e);
    void deleteById(int id);
}
