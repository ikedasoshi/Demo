package com.example.demo.controller.simulator;

import javax.annotation.PostConstruct;
import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.transaction.annotation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.controller.simulator.SimuData;
import com.example.demo.controller.repositories.SimuDataRepository;

@Controller
public class SimuDataDAO_Controller {
    
    @Autowired
    SimuDataRepository repository;

    @PersistenceContext
    EntityManager entityManager;

    SimuDataDAOImpl dao;

    @PostConstruct
    public void init() {
        dao = new SimuDataDAOImpl(entityManager);
    }

    @RequestMapping(value = "/simudatadao", method = RequestMethod.GET)
    public ModelAndView mydatadao(ModelAndView mav) {
        mav.setViewName("simulator/simudatadao");
        mav.addObject("msg", "this is sample comment");
        Iterable<SimuData> list = dao.getAll();
        mav.addObject("datalist", list);
        return mav;
    }
}