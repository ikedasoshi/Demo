package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.controller.repositories.MyDataRepository;

@Controller
public class MyDataController {
    
    @Autowired
    MyDataRepository repository;

    @RequestMapping("/mydatatest")
    public ModelAndView mydatatest(ModelAndView mav) {
        mav.setViewName("chapter5/mydatatest");
        mav.addObject("msg", "this is sample comment");
        Iterable<MyData> list = repository.findAll();
        mav.addObject("data", list);
        return mav;
    }
}