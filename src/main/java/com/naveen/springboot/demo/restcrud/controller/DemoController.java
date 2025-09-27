package com.naveen.springboot.demo.restcrud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DemoController {

    @GetMapping("/demo")
    public String sayHello(){
        return "Hello World !!!";
    }
}
