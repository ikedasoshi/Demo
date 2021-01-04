package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OGNL_Controller {
    
    @RequestMapping("/ognl")
    public ModelAndView ognlsample(ModelAndView mav) {
        mav.setViewName("chapter4/ognlsample");
        return mav;
    }

    @RequestMapping("/ognl2")
    public ModelAndView ognlsample2(ModelAndView mav) {
        mav.setViewName("chapter4/ognlsample2");
        return mav;
    }

    @RequestMapping("/ognl3")
    public ModelAndView ognlsample3(ModelAndView mav) {
        mav.setViewName("chapter4/ognlsample3");
        return mav;
    }
}