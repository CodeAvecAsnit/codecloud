package com.labwork.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/api/hello")
    public String getHelloMessage() {
        return "Welcome to the Spring MVC REST API!";
    }
}
