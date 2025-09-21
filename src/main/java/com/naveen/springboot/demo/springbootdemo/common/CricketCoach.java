package com.naveen.springboot.demo.springbootdemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//Component annotation marks the class as a Spring bean & make it available for dependency injection
@Component
@Primary
public class CricketCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Cricket coach !!!";
    }
}
