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
}