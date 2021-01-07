package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
    @RequestMapping(value = "/counter_test")
    public ModelAndView countertest(ModelAndView mav) {
        mav.setViewName("counter_test");
        return mav;
    }

    @RequestMapping("/counter_test2/{mag}")
    public ModelAndView countertest2(@PathVariable int mag, ModelAndView mav) {
        mav.setViewName("counter_test2");
        mav.addObject("mag", mag);
        return mav;
    }

    @RequestMapping("/counter_test3/{mag}")
    public ModelAndView countertest3(@PathVariable int mag, ModelAndView mav) {
        mav.setViewName("counter_test3");
        mav.addObject("mag", mag);
        mav.addObject("msg", "1クリック" + mag + "点");
        return mav;
    }
}