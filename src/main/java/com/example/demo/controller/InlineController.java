package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InlineController {
    
    @RequestMapping("/inlinetest")
    public ModelAndView inlinetest(ModelAndView mav) {
        mav.setViewName("chapter4/inlinetest");
        ArrayList<DataObject> data = new ArrayList<DataObject>();
        data.add(new DataObject(0,"taro","taro@yamada"));
        data.add(new DataObject(1,"hanako","hanako@flower"));
        data.add(new DataObject(2,"sachiko","sachiko@happy"));
        mav.addObject("data", data);
        return mav;
    }
}