package com.naveen.springboot.demo.restjpadatacrud.service;

import com.naveen.springboot.demo.restjpadatacrud.dao.EmployeeRepository;
import com.naveen.springboot.demo.restjpadatacrud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository mEmployeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.mEmployeeRepository = employeeRepository;
    }

    @Override
    public Employee save(Employee employee) {
        return mEmployeeRepository.save(employee);
    }

    @Override
    public List<Employee> findAll() {
        return mEmployeeRepository.findAll();
    }

    @Override
    public Employee findById(Integer employeeId) {
        Optional<Employee> result = mEmployeeRepository.findById(employeeId);
        Employee employee = null;

        if(result.isPresent()){
            employee = result.get();
        } else {
            throw new RuntimeException("Did not find employee id - " + employeeId);
        }

        return employee;
    }

    @Override
    public void update(Employee employee) {
    }

    @Override
    public void deleteById(Integer id) {
        mEmployeeRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
         mEmployeeRepository.deleteAll();
    }

}
