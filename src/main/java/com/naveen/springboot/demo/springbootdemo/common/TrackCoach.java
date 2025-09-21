package com.naveen.springboot.demo.springbootdemo.common;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "TrackCoach";
    }
}
