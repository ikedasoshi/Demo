package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IfSampleController {
    @RequestMapping("/ifsample/{id}")
    public ModelAndView ifsample(@PathVariable int id, ModelAndView mav) {
        mav.setViewName("chapter4/ifsample");
        mav.addObject("id", id);
        mav.addObject("check", id % 2 == 0);
        mav.addObject("trueVal", "Even number");
        mav.addObject("falseVal", "Odd number");
        return mav;
    }

    @RequestMapping("/thifsample/{id}")
    public ModelAndView thifsample(@PathVariable int id, ModelAndView mav) {
        mav.setViewName("chapter4/thifsample");
        mav.addObject("id", id);
        mav.addObject("check", id >= 0);
        mav.addObject("trueVal", "Positive");
        mav.addObject("falseVal", "Negative");
        return mav;
    }

    @RequestMapping("/thswitch/{month}")
    public ModelAndView thswitch(@PathVariable int month, ModelAndView mav) {
        mav.setViewName("chapter4/thswitch");
        int m = Math.abs(month) % 12;
        m = m == 0 ? 12 : m;
        mav.addObject("month", m);
        mav.addObject("check", Math.floor(m / 3));
        return mav;
    }
}