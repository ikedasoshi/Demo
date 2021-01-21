package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.annotation.PostConstruct;
import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.transaction.annotation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.MyDataDAOImpl;
import com.example.demo.controller.repositories.MyDataRepository;

@Controller
public class DAO_FindController {
    
    @Autowired
    MyDataRepository repository;

    @PersistenceContext
    EntityManager entityManager;

    MyDataDAOImpl dao;

    @PostConstruct
    public void init() {
        dao = new MyDataDAOImpl(entityManager);
    }

    @RequestMapping(value = "/mydatadao", method = RequestMethod.GET)
    public ModelAndView mydatadao(ModelAndView mav) {
        mav.setViewName("chapter6/mydatadao");
        mav.addObject("msg", "this is sample comment");
        Iterable<MyData> list = dao.getAll();
        mav.addObject("datalist", list);
        return mav;
    }
}