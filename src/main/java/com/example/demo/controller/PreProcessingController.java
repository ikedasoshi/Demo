package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PreProcessingController {
    @RequestMapping("/preprocessing/{num}")
    public ModelAndView requestMethodName(@PathVariable int num, ModelAndView mav) {
        mav.setViewName("chapter4/preprocessing");
        mav.addObject("num",num);
        if(num >= 0) {
            mav.addObject("check", "num >= data.size() ? 0 :num");
        } else {
            mav.addObject("check", "num <= data.size() * -1 ? 0 :num * -1");
        }
        ArrayList<DataObject> data = new ArrayList<DataObject>();
        data.add(new DataObject(0,"taro","taro@yamada"));
        data.add(new DataObject(1,"hanako","hanako@flower"));
        data.add(new DataObject(2,"sachiko","sachiko@happy"));
        mav.addObject("data", data);
        return mav;
    }
}