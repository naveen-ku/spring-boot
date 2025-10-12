package com.naveen.springboot.demo.manytotmany.dao;

import com.naveen.springboot.demo.manytotmany.entity.Course;

public interface AppDao {
    void saveCourseWithStudent(Course course);
}
