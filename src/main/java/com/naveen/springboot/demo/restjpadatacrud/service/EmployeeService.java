package com.naveen.springboot.demo.restjpadatacrud.service;


import com.naveen.springboot.demo.restjpadatacrud.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee save(Employee employee);
    Employee findById(Integer id);
    List<Employee> findAll();
    void update(Employee employee);
    void deleteById(Integer id);
    void deleteAll();
}
