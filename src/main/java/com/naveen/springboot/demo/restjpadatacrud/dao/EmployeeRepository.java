package com.naveen.springboot.demo.restjpadatacrud.dao;

import com.naveen.springboot.demo.restjpadatacrud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // that's it... no code required for basic CRUD code
}
