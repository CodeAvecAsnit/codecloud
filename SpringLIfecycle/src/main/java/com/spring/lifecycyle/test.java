package com.spring.lifecycyle;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    public static void main(String[] args) {
        AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("lifecycle.xml");

        Food food = (Food) applicationContext.getBean("s1");
        System.out.println(food.getFoodName());
        System.out.println(food.getFoodPrice());
        applicationContext.registerShutdownHook();
        applicationContext.close();


    }
}
