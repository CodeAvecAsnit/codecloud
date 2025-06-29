package com.spring.autowired;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static java.lang.System.exit;

public class tester {
    public static void main(String[] args) {
//        AbstractApplicationContext context = new ClassPathXmlApplicationContext("autowired.xml");
//        emp Emp = (emp) context.getBean("emp");
//        System.out.println(Emp.toString());

        String coordinates = "a1";
        char alpha = coordinates.charAt(0);
        int num = Integer.parseInt(coordinates.substring(1));
    }
}
