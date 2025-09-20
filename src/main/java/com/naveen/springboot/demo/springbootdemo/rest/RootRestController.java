package com.naveen.springboot.demo.springbootdemo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class RootRestController {

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
