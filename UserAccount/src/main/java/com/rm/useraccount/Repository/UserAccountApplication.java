package com.rm.useraccount.Repository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.rm.useraccount.Controllers", "com.rm.useraccount.Service", "com.rm.useraccount.Models"})
public class UserAccountApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserAccountApplication.class, args);
    }
}