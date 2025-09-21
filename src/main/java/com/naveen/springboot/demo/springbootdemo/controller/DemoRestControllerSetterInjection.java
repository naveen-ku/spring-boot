package com.naveen.springboot.demo.springbootdemo.controller;

import com.naveen.springboot.demo.springbootdemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestControllerSetterInjection {

    private Coach myCoach;

    @Autowired
    public void setCoach(Coach theCoach){
        myCoach = theCoach;
    }

    @GetMapping("/setter-dailyworkout")
    public String route(){
        return "Setter: " + myCoach.getDailyWorkout();
    }

}
