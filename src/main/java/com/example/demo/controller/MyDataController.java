package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.controller.repositories.MyDataRepository;

//import javax.annotation.PostConstruct;


@Controller
public class MyDataController {
/*
    @PostConstruct
public void init() {
    MyData d1 = new MyData();
    d1.setName("tuyano");
    d1.setAge(23);
    d1.setMail("shoda@tuyano.com");
    d1.setMemo("this is my data");
    repository.saveAndFlush(d1);

    MyData d2 = new MyData();
    d2.setName("hanako");
    d2.setAge(15);
    d2.setMail("hanako@flower");
    d2.setMemo("my girl friend");
    repository.saveAndFlush(d2);

    MyData d3 = new MyData();
    d3.setName("sachiko");
    d3.setAge(37);
    d3.setMail("sachio@happy");
    d3.setMemo("my work friend");
    repository.saveAndFlush(d3);
}
*/
    @Autowired
    MyDataRepository repository;

    @RequestMapping(value = "/mydatatest", method = RequestMethod.GET)
    public ModelAndView mydatatest(@ModelAttribute("formModel") MyData mydata, ModelAndView mav) {
        mav.setViewName("chapter5/mydatatest");
        mav.addObject("msg", "this is sample comment");
        Iterable<MyData> list = repository.findAll();
        mav.addObject("datalist", list);
        return mav;
    }

    @RequestMapping(value = "/mydatatest", method = RequestMethod.POST)
    @Transactional(readOnly = false)
    public ModelAndView form(@ModelAttribute("formModel") MyData mydata, ModelAndView mav) {
        repository.saveAndFlush(mydata);
        return new ModelAndView("redirect:/mydatatest");
    }
}