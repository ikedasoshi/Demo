package com.example.demo.controller.simulator;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.controller.simulator.SimuData;
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
        mav.setViewName("simulator/index");
        Iterable<SimuData> list = repository.findAll();
        mav.addObject("datalist", list);
        return mav;
    }

    @RequestMapping(value = "/counter/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@ModelAttribute SimuData simudata, @PathVariable int id, ModelAndView mav) {
        mav.setViewName("simulator/counter");
        mav.addObject("title", "edit mydata.");
        Iterable<SimuData> list = repository.findAll();
        mav.addObject("datalist", list);
        Optional<SimuData> data = repository.findById((long)id);
        mav.addObject("formModel", data.get());
        return mav;
    }

    @RequestMapping(value = "/selectdata", method = RequestMethod.GET)
    public ModelAndView select(HttpServletRequest request, ModelAndView mav) {
        mav.setViewName("simulator/selectdata");
        mav.addObject("title", "Find Page");
        mav.addObject("msg", "this is MyData sample");
        Iterable<SimuData> list = dao.getAll();
        mav.addObject("datalist", list);
        return mav;
    }

    @RequestMapping(value = "/selectdata", method = RequestMethod.POST)
    public ModelAndView search(HttpServletRequest request, ModelAndView mav, RedirectAttributes redirectAttributes, @RequestParam("fstr") long param) {
        //mav.addObject("wid", param);
        redirectAttributes.addAttribute("id",param);
        return new ModelAndView("redirect:/counter/{id}");
    }
}