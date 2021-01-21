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

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public ModelAndView find(HttpServletRequest request, ModelAndView mav) {
        mav.setViewName("chapter6/find");
        mav.addObject("title", "Find Page");
        mav.addObject("msg", "this is MyData sample");
        mav.addObject("value", "");
        Iterable<MyData> list = dao.getAll();
        mav.addObject("datalist", list);
        return mav;
    }

    @RequestMapping(value = "/find", method = RequestMethod.POST)
    public ModelAndView search(HttpServletRequest request, ModelAndView mav) {
        mav.setViewName("chapter6/find");
        String param = request.getParameter("fstr");
        if (param == "") {
            mav = new ModelAndView("redirect:/find");
        } else {
            mav.addObject("title", "Find result");
            mav.addObject("msg", "「" + param + "」の検索結果");
            mav.addObject("value", param);
            List<MyData> list = dao.find(param);
            mav.addObject("datalist", list);
        }
        
        return mav;
    }
}