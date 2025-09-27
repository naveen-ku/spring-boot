package com.naveen.springboot.demo.springbootdemo.controller;

import com.naveen.springboot.demo.springbootdemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestControllerSetterInjection {

    private Coach myCoach;

    //  Dependency injection using setters method
    @Autowired
    public void setCoach(Coach theCoach){
        myCoach = theCoach;
    }

    // Since CricketCoach is set as primary - CricketCoach will be injected
    // Observe there is no constructor here, so injection happens using setter injection
    @GetMapping("/setter-dailyworkout")
    public String route(){
        return "Setter: " + myCoach.getDailyWorkout();
    }

}
