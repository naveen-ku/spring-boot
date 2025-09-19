package com.naveen.springboot.demo.springbootdemo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootRestController {

    // expose "/" endpoint
    @GetMapping("/")
    public  String sayHello(){
        return "Hello world!";
    }
}
