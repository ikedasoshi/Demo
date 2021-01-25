package com.example.demo.controller.simulator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.controller.simulator.SimuDataRepository;

@Controller
public class S_CRUD_Controller {
    
    @Autowired
    SimuDataRepository repository;

    @RequestMapping("/s_read")
    public ModelAndView read(ModelAndView mav) {
        mav.setViewName("simulator/s_read");
        mav.addObject("msg", "this is sample comment");
        Iterable<SimuData> list = repository.findAll();
        mav.addObject("datalist", list);
        return mav;
    }
}