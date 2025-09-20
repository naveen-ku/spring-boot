package com.naveen.springboot.demo.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class RootRestController {

    // Inject properties using annotation
    @Value("${coach.name}")
    private String coachName;
    @Value("${team.name}")
    private String teamName;

    @GetMapping("/teaminfo")
    public String getTeamInfo(){
        return "Coach: " + coachName + ", TeamName: " + teamName;
    }

    // expose "/" endpoint
    @GetMapping("/")
    public String rootRoute(){
        return "Root world live changes";
    }

    @GetMapping("/hello")
    public  String sayHello(){
        return "Hello world!";
    }

    @GetMapping("/new")
    public String newEnd(){
        return  "New";
    }

}
