package com.naveen.springboot.demo.aop;

import com.naveen.springboot.demo.aop.dao.AccountDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringboardApplication {
    static void main(String[] args) {
        SpringApplication.run(SpringboardApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AccountDao accountDao) {
        return runner -> {
            System.out.println("AOP Demo");
            demoTheBeforeAdvice(accountDao);
        };
    }

    private void demoTheBeforeAdvice(AccountDao accountDao) {
        accountDao.addAccount();
    }
}
