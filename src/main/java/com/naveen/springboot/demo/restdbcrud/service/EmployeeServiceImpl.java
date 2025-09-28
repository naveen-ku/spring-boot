package com.naveen.springboot.demo.restdbcrud.service;


import com.naveen.springboot.demo.restdbcrud.dao.EmployeeDAO;
import com.naveen.springboot.demo.restdbcrud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeDAO mEmployeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO mEmployeeDAO) {
        this.mEmployeeDAO = mEmployeeDAO;
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return mEmployeeDAO.save(employee);
    }

    @Override
    public List<Employee> findAll() {
        return mEmployeeDAO.findAll();
    }

    @Override
    public Employee findById(Integer employeeId) {
        return mEmployeeDAO.findById(employeeId);
    }

    @Override
    @Transactional
    public void update(Employee employee) {

    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        mEmployeeDAO.deleteById(id);
    }

    @Override
    @Transactional
    public int deleteAll() {
        return mEmployeeDAO.deleteAll();
    }

}
