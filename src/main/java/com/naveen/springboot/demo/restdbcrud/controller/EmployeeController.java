package com.naveen.springboot.demo.restdbcrud.controller;


import com.naveen.springboot.demo.restdbcrud.entity.Employee;
import com.naveen.springboot.demo.restdbcrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private EmployeeService mEmployeeService;

    @Autowired
    public void EmployeeController(EmployeeService employeeService){
        this.mEmployeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return mEmployeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeesById(@PathVariable int employeeId){
        return mEmployeeService.findById(employeeId);
    }

    @PostMapping("/employees")
    public Employee saveEmployees(){
        Employee employee = new Employee("Naveen","Kumar","naveen@gmail.com");
        Employee dbEmployee =  mEmployeeService.save(employee);
        return dbEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployeesById(@PathVariable int employeeId){
        mEmployeeService.deleteById(employeeId);
        return "Delete successful !!!";
    }

    @DeleteMapping("/employees")
    public String deleteAllEmployees(){
        int numRowDeleted = mEmployeeService.deleteAll();
        return "Number of rows deleted" + numRowDeleted;
    }
}
