package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class TestController {
    @RequestMapping("/counter_test")
    public String index() {
        return "counter_test";
    }
}