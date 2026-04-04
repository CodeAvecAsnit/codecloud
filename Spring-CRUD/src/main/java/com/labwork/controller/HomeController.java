package com.labwork.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/hello")
    public String showHelloPage(Model model) {
        model.addAttribute("message", "Welcome to the Spring MVC & JDBC Application!");
        return "hello";
    }
}
