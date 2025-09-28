package com.naveen.springboot.demo.restdbcrud.dao;

import com.naveen.springboot.demo.restdbcrud.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    private EntityManager mEntityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager){
        this.mEntityManager = entityManager;
    }

    @Override
    public Employee save(Employee employee) {
        Employee dbEmployee = mEntityManager.merge(employee);
        return dbEmployee;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = mEntityManager.createQuery("FROM Employee", Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee findById(Integer id) {
        return mEntityManager.find(Employee.class, id);
    }

    @Override
    public void update(Employee employee) {
        mEntityManager.merge(employee);
    }

    @Override
    public void deleteById(Integer id) {
        Employee employee = mEntityManager.find(Employee.class, id);
        mEntityManager.remove(employee);
    }

    @Override
    public int deleteAll() {
        int numRowsDeleted = mEntityManager.createQuery("DELETE FROM Employee").executeUpdate();
        return numRowsDeleted;
    }
}
