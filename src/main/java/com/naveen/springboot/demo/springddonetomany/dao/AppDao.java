package com.naveen.springboot.demo.springddonetomany.dao;


import com.naveen.springboot.demo.springddonetomany.entity.Instructor;
import com.naveen.springboot.demo.springddonetomany.entity.InstructorDetail;

public interface AppDao {
    void saveInstructor(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);
    void deleteInstructorDetailById(int id);
}
