package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String index() {
        return "chapter3/hello";
    }

    @RequestMapping("hello2/{num}")
    public String index2(@PathVariable int num, Model model) {
        int res = 0;
        for(int i = 1; i <= num; i++) {
            res += i;
        }
        model.addAttribute("msg", "total: " + res);
        return "chapter3/hello2";
    }
}


