package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FragmentTestController {
    @RequestMapping("/fragtest")
    public ModelAndView fragtest(ModelAndView mav) {
        mav.setViewName("chapter4/fragtest");
        return mav;
    }
}