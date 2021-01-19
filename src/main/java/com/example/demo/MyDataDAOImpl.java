package com.example.demo;

import java.util.List;
import javax.persistence.*;

import com.example.demo.controller.MyData;

import org.springframework.stereotype.Repository;

@Repository
public class MyDataDAOImpl implements MyDataDAO<MyData> {
    private static final long serialVersionUID = 1L;

    private EntityManager entityManager;

    public MyDataDAOImpl() {
        super();
    }
    public MyDataDAOImpl(EntityManager manager) {
        this();
        entityManager = manager;
    }

    @Override
    public List<MyData> getAll() {
        Query query = entityManager.createQuery("from MyData");
        @SuppressWarnings("unchecked")
        List<MyData> list = query.getResultList();
        entityManager.close();
        return list;
    }
}