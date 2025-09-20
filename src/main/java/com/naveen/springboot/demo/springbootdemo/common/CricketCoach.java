package com.naveen.springboot.demo.springbootdemo.common;

import org.springframework.stereotype.Component;

//Component annotation marks the class as a Spring bean & make it available for dependency injection
@Component
public class CricketCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 10 min !!!";
    }
}
