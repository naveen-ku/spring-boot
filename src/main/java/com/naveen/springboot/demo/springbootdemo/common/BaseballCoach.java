package com.naveen.springboot.demo.springbootdemo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Baseball coach";
    }
}
