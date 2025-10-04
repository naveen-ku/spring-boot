package com.naveen.springboot.demo.springdbmappings.dao;

import com.naveen.springboot.demo.springdbmappings.entity.Instructor;
import com.naveen.springboot.demo.springdbmappings.entity.InstructorDetail;

public interface AppDao {
    void saveInstructor(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);
    void deleteInstructorDetailById(int id);
}
