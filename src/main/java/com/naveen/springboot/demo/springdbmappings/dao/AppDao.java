package com.naveen.springboot.demo.springdbmappings.dao;

import com.naveen.springboot.demo.springdbmappings.entity.Instructor;

public interface AppDao {
    void saveInstructor(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);
}
