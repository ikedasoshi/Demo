package com.example.demo.controller.bbps4;

import java.util.List;
import javax.persistence.*;

import com.example.demo.controller.bbps4.SimuData;

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

    @Override
    public SimuData findById(long id) {
        return (SimuData)entityManager.createQuery("from SimuData where id = " + id).getSingleResult();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<SimuData> findByName(String name) {
        return (List<SimuData>)entityManager.createQuery("from SimuData where name = " + name).getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<SimuData> find(String fstr) {
        List<SimuData> list = null;
        String qstr = "from SimuData where id = ?1 or name like ?2";
        Long fid = 0L;
        try {
            fid = Long.parseLong(fstr);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        Query query = entityManager.createQuery(qstr)
            .setParameter(1, fid)
            .setParameter(2, "%" + fstr + "%");
        list = query.getResultList();
        return list;
    }
}