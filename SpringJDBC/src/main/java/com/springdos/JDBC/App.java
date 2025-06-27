package com.springdos.JDBC;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class App  {
    public static void main(String[] args) {


        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        StdntDao stdntDao = (StdntDao) context.getBean("stdntDao");
        List<Student> std = stdntDao.getAllStudent();
        for (Student s : std) {
            System.out.println(s.toString());
        }

    }
}


