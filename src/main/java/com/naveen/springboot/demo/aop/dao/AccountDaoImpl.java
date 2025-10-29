package com.naveen.springboot.demo.aop.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao {
    @Override
    public void addAccount() {
        System.out.println(getClass() + ": runs add account...");
    }
}
