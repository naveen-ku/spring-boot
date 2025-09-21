package com.naveen.springboot.demo.springbootdemo.common;

import org.springframework.context.annotation.Configuration;

public class SwimCoach implements Coach{

    public SwimCoach(){
        System.out.println("In constructor " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Swim coach";
    }
}
