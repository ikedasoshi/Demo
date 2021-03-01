package com.example.demo.controller.bbps4;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.controller.repositories.SimuDataRepository;

@Controller
public class S_CRUD_Controller {
    
    @Autowired
    SimuDataRepository repository;

    @RequestMapping("/s_read")
    public ModelAndView read(ModelAndView mav) {
        mav.setViewName("simulator/s_read");
        mav.addObject("msg", "this is sample comment");
        Iterable<SimuData> list = repository.findAll();
        mav.addObject("data", list);
        return mav;
    }

    @RequestMapping(value = "/s_create", method = RequestMethod.GET)
    public ModelAndView create(@ModelAttribute("formModel") SimuData simudata, ModelAndView mav) {
        mav.setViewName("simulator/s_create");
        mav.addObject("msg", "this is sample comment");
        Iterable<SimuData> list = repository.findAll();
        mav.addObject("datalist", list);
        return mav;
    }

    @RequestMapping(value = "/s_create", method = RequestMethod.POST)
    @Transactional(readOnly = false)
    public ModelAndView form(@ModelAttribute("formModel") SimuData simudata, ModelAndView mav) {
        repository.saveAndFlush(simudata);
        return new ModelAndView("redirect:/s_create");
    }

    @RequestMapping(value = "/s_edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@ModelAttribute SimuData simudata, @PathVariable int id, ModelAndView mav) {
        mav.setViewName("simulator/s_edit");
        mav.addObject("title", "edit mydata.");
        Iterable<SimuData> list = repository.findAll();
        mav.addObject("datalist", list);
        Optional<SimuData> data = repository.findById((long)id);
        mav.addObject("formModel", data.get());
        return mav;
    }

    @RequestMapping(value = "/s_edit", method = RequestMethod.POST)
    @Transactional(readOnly = false)
    public ModelAndView update(@ModelAttribute SimuData simudata, ModelAndView mav) {
        repository.saveAndFlush(simudata);
        return new ModelAndView("redirect:/s_read");
    }

    @RequestMapping(value = "/s_delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable int id, ModelAndView mav) {
        mav.setViewName("simulator/s_delete");
        mav.addObject("title", "delete simudata.");
        Iterable<SimuData> list = repository.findAll();
        mav.addObject("datalist", list);
        Optional<SimuData> data = repository.findById((long)id);
        mav.addObject("formModel", data.get());
        return mav;
    }

    @RequestMapping(value = "/s_delete", method = RequestMethod.POST)
    @Transactional(readOnly = false)
    public ModelAndView remove(@RequestParam long id, ModelAndView mav) {
        repository.deleteById(id);
        return new ModelAndView("redirect:/s_read");
    }
}