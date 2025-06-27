package com.spring2.Bean1;


import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static java.lang.System.exit;

public class App
{
    public static void main(String[] args) {
//        AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring2config.xml");
//        Bankaccount bankaccount = context.getBean("bankaccount", Bankaccount.class);
//        bankaccount.setUserName("Krishna");
//        System.out.println(bankaccount.toString());
//
//        Bankaccount bankaccount1 = context.getBean("bankaccount", Bankaccount.class);
//        System.out.println(bankaccount1.toString());
       int n =  2147483647;
       long sum = 0;
       for (int i = 0; i <=n; i++) {
           sum += i;
           if(sum==n){
               System.out.println(i);
               exit(0);
           }else if(sum>n){
               System.out.println(i-1);
               exit(0);
           }
       }
        System.out.println(n);
    }
}
