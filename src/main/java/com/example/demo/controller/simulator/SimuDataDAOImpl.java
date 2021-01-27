package com.example.demo.controller.simulator;

import java.util.List;
import javax.persistence.*;

import com.example.demo.controller.simulator.SimuData;

import org.springframework.stereotype.Repository;

@Repository
public class SimuDataDAOImpl implements SimuDataDAO<SimuData> {

    private static final long serialVersionUID = 1L;

    private EntityManager entityManager;

    public SimuDataDAOImpl() {
        super();
    }
    public SimuDataDAOImpl(EntityManager manager) {
        this();
        entityManager = manager;
    }

    @Override
    public List<SimuData> getAll() {
        Query query = entityManager.createQuery("from SimuData");
        @SuppressWarnings("unchecked")
        List<SimuData> list = query.getResultList();
        entityManager.close();
        return list;
    }
}