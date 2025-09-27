package com.naveen.springboot.demo.springbootdemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class BaseballCoach implements Coach{

    public BaseballCoach(){
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
        return "Baseball coach";
    }
}
