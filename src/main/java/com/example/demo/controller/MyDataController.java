package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.controller.repositories.MyDataRepository;

@Controller
public class MyDataController {
    
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
        return new ModelAndView("redirect:/chapter5/mydatatest");
    }
}