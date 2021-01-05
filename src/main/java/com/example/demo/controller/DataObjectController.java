package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class DataObjectController {
    @RequestMapping("/dotest")
    public ModelAndView dotest(ModelAndView mav) {
        mav.setViewName("chapter4/dotest");
        mav.addObject("title", "DataObject");
        mav.addObject("msg", "current data.");
        DataObject obj = new DataObject(123, "hanako", "hanako@flower");
        mav.addObject("object", obj);
        return mav;
    }
}

class DataObject {
    private int id;
    private String name;
    private String value;

    public DataObject(int id, String name, String value) {
        super();
        this.id = id;
        this.name = name;
        this.value = value;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }

}