package com.example.demoapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    @RequestMapping("/test")
    public @ResponseBody String greeding(){
        return "Hello world";
    }
}
