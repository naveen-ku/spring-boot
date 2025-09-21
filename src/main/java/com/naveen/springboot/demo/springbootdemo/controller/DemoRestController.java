package com.naveen.springboot.demo.springbootdemo.controller;

import com.naveen.springboot.demo.springbootdemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {
    private Coach myCoach;
    private Coach swimCoach;

    @Autowired
    public DemoRestController(@Qualifier("tennisCoach") Coach theCoach, @Qualifier("swimCoach") Coach sCoach){
        myCoach = theCoach;
        swimCoach = sCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/swim")
    public String getSwimWorkout(){
        return swimCoach.getDailyWorkout();
    }


}
