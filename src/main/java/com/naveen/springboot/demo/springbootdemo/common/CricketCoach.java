package com.naveen.springboot.demo.springbootdemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//Component annotation marks the class as a Spring bean & make it available for dependency injection
@Component
@Primary
@Lazy
public class CricketCoach implements Coach {

    public CricketCoach(){
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
        return "Cricket coach !!!";
    }
}
