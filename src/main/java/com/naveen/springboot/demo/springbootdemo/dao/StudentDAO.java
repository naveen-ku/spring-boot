package com.naveen.springboot.demo.springbootdemo.dao;

import com.naveen.springboot.demo.springbootdemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);
    Student findById(Integer id);
    List<Student> findAll();
}
