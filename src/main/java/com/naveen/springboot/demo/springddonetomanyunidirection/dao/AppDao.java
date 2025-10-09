package com.naveen.springboot.demo.springddonetomany.dao;


import com.naveen.springboot.demo.springddonetomany.entity.Course;
import com.naveen.springboot.demo.springddonetomany.entity.Instructor;
import com.naveen.springboot.demo.springddonetomany.entity.InstructorDetail;

import java.util.List;

public interface AppDao {
    void saveInstructor(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

    void updateInstructor(Instructor instructor);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);

    public List<Course> findCoursesByInstructorId(int id);

    Instructor findInstructorByIdJoinFetchCourses(int id);

    void updateCourse(Course tempCourse);

    Course findCourseById(int id);

    void deleteCourseById(int id);

    void addCourseToExistingInstructor(int id);
}
