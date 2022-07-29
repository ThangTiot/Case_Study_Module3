package com.example.casestudy.DAO;

import java.util.ArrayList;

public interface CRUDRepository<E> {
    ArrayList<E> findAll();
    void create(E e);

    void deleteById(int id);
}
