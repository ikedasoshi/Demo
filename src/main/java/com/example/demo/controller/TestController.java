package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
    @RequestMapping(value = "/counter_test", method = RequestMethod.GET)
    public ModelAndView countertest(ModelAndView mav) {
        mav.setViewName("counter_test");
        return mav;
    }
}