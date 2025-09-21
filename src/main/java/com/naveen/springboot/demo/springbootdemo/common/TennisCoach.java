package com.naveen.springboot.demo.springbootdemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class TennisCoach implements Coach{

    public TennisCoach(){
        System.out.println("In constructor lazy " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Tennis Coach!";
    }
}
