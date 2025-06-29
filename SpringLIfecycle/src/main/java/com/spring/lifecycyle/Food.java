package com.spring.lifecycyle;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Food {
    private String foodName;
    private int foodPrice;

    public Food(String foodName, int foodPrice) {
        this.foodName = foodName;
    }

    public Food() {}

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
    public String getFoodName() {
        return foodName;
    }
    public void setFoodPrice(int foodPrice) {
        System.out.println("Setting property");
        this.foodPrice = foodPrice;
    }
    public int getFoodPrice() {
        return foodPrice;
    }

    @PostConstruct
    public void init(){
        System.out.println("Inside the init method");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Inside the destroy method");
    }
}
