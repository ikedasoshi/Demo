package com.example.demo.controller.bbps4;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.controller.bbps4.SimuData;
import com.example.demo.controller.repositories.SimuDataRepository;

@Controller
public class S_Simulator_Controller {
    
    @Autowired
    SimuDataRepository repository;

    @PersistenceContext
    EntityManager entityManager;

    SimuDataDAOImpl dao;

    @PostConstruct
    public void init() {
        dao = new SimuDataDAOImpl(entityManager);
    }

    @RequestMapping("/")
    public ModelAndView index(ModelAndView mav) {
        mav.setViewName("bbps4/index");
        Iterable<SimuData> list = repository.findAll();
        mav.addObject("datalist", list);
        return mav;
    }

    @RequestMapping(value = "/counter/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@ModelAttribute SimuData simudata, @PathVariable int id, ModelAndView mav) {
        mav.setViewName("bbps4/counter");
        mav.addObject("title", "連射測定");
        Iterable<SimuData> list = repository.findAll();
        mav.addObject("datalist", list);
        Optional<SimuData> data = repository.findById((long)id);
        mav.addObject("formModel", data.get());
        return mav;
    }
}