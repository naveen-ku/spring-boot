package com.naveen.springboot.demo.manytotmany.dao;

import com.naveen.springboot.demo.manytotmany.entity.Course;
import com.naveen.springboot.demo.manytotmany.entity.Student;

public interface AppDao {
    void saveCourseWithStudent(Course course);

    Course findCourseAndStudentByCourseId(int id);

    Student findStudentAndCourseByStudentId(int id);

    void updateStudent(Student student);

    void deleteCourseById(int id);

    void deleteStudentById(int id);
}
