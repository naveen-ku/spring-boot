package com.naveen.springboot.demo.springbootdemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Configuration;

public class SwimCoach implements Coach{

    public SwimCoach(){
        System.out.println("In constructor " + getClass().getSimpleName());
    }

    // define init method
    @PostConstruct
    public void init(){
        System.out.println("In init() " + getClass().getSimpleName());
    }

    @PreDestroy
    public void cleanUp(){
        System.out.println("In cleanUp() " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Swim coach";
    }
}
