package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MovePageController {
    
    @RequestMapping("/movepage")
    public ModelAndView mpsample(ModelAndView mav) {
        mav.setViewName("chapter3/movepage");
        return mav;
    }

    @RequestMapping("/other")
    public String other() {
        return "redirect:/chapter3/movepage";
    }

    @RequestMapping("/home")
    public String home() {
        return "forward:/chapter3/movepage";
    }
}