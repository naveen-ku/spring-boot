package com.naveen.springboot.demo.restdbcrud.service;

import com.naveen.springboot.demo.restdbcrud.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee save(Employee employee);
    Employee findById(Integer id);
    List<Employee> findAll();
    void update(Employee employee);
    void deleteById(Integer id);
    int deleteAll();
}
