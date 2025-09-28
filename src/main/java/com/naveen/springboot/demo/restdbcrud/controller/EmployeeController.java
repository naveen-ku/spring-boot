package com.naveen.springboot.demo.restdbcrud.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.naveen.springboot.demo.restdbcrud.entity.Employee;
import com.naveen.springboot.demo.restdbcrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private EmployeeService mEmployeeService;
    private ObjectMapper mObjectMapper;

    @Autowired
    public void EmployeeController(EmployeeService employeeService, ObjectMapper objectMapper){
        this.mEmployeeService = employeeService;
        this.mObjectMapper = objectMapper;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return mEmployeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeesById(@PathVariable int employeeId){
        Employee employee =  mEmployeeService.findById(employeeId);
        if(employee == null){
            throw new RuntimeException("Employee not found - " + employeeId);
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee saveEmployees(@RequestBody Employee employee){

        // Case if the user add some id value then we are setting it to 0 because in DAOImpl
        // we used the merge function which create new record if id is not found (or 0) or
        // update if id is found
        employee.setId(0);
        Employee dbEmployee =  mEmployeeService.save(employee);
        return dbEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployeesById(@PathVariable int employeeId){
        Employee employee = mEmployeeService.findById(employeeId);

        if(employee == null){
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        mEmployeeService.deleteById(employeeId);
        return "Delete successful !!!";
    }

    @DeleteMapping("/employees")
    public String deleteAllEmployees(){
        int numRowDeleted = mEmployeeService.deleteAll();
        return "Number of rows deleted - " + numRowDeleted;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        Employee dbEmployee = mEmployeeService.save(employee);
        return dbEmployee;
    }

    @PatchMapping("/employees/{employeeId}")
    public Employee partialUpdateEmployee(@PathVariable int employeeId, @RequestBody Map<String, Object> patchPayload){

        Employee dbEmployee = mEmployeeService.findById(employeeId);

        if(dbEmployee == null){
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        if(patchPayload.containsKey("id")){
            throw new RuntimeException("Employee id is not allowed in request body - " + employeeId);
        }

        Employee patchedEmployee = apply(patchPayload, dbEmployee);

        Employee updatedEmployee = mEmployeeService.save(patchedEmployee);

        return updatedEmployee;
    }

    private Employee apply(Map<String, Object> patchPayload, Employee dbEmployee){

//        Convert employee object to a JSON object node
        ObjectNode dbEmployeeNode = mObjectMapper.convertValue(dbEmployee, ObjectNode.class);

//        Convert patchPayload map to a JSON object node
        ObjectNode patchNode = mObjectMapper.convertValue(patchPayload, ObjectNode.class);

//        Merge the patch updates into the employee node
        dbEmployeeNode.setAll(patchNode);

        return mObjectMapper.convertValue(dbEmployeeNode, Employee.class);
    }
}
