package com.example.demo.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormController {
    
    @RequestMapping(value = "/formsample", method = RequestMethod.GET)
    public ModelAndView formget(ModelAndView mav) {
        mav.setViewName("chapter3/formsample");
        mav.addObject("msg", "お名前を書いて送信してください");
        return mav;
    }

    @RequestMapping(value = "/formsample", method = RequestMethod.POST)
    public ModelAndView formpost(@RequestParam("text1")String str, ModelAndView mav) {
        mav.addObject("msg", "こんにちは、" + str + "さん！");
        mav.addObject("value", str);
        mav.setViewName("chapter3/formsample");
        return mav;
    }
}