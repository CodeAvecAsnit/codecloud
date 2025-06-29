package com.spring;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");


        Student student2 = (Student) context.getBean("student1");
        student2.setId(24);
        System.out.println(student2.toString());
        System.out.println(student2.getSchool().toString());

        for(String miss : student2.getList()){
            System.out.println(miss);
        }
    }
}

