package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.controller.repositories.MyDataRepository;

@Controller
public class DeleteController {
    
    @Autowired
    MyDataRepository repository;

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable int id, ModelAndView mav) {
        mav.setViewName("chapter5/delete");
        mav.addObject("title", "delete mydata.");
        Iterable<MyData> list = repository.findAll();
        mav.addObject("datalist", list);
        Optional<MyData> data = repository.findById((long)id);
        mav.addObject("formModel", data.get());
        return mav;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @Transactional(readOnly = false)
    public ModelAndView remove(@RequestParam long id, ModelAndView mav) {
        repository.deleteById(id);
        return new ModelAndView("redirect:/mydatatest");
    }
}