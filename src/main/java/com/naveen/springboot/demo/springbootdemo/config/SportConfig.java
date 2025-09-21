package com.naveen.springboot.demo.springbootdemo.config;

import com.naveen.springboot.demo.springbootdemo.common.Coach;
import com.naveen.springboot.demo.springbootdemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
