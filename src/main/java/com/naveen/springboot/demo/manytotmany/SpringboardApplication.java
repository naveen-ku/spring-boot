package com.naveen.springboot.demo.manytotmany;

import com.naveen.springboot.demo.manytotmany.dao.AppDao;
import com.naveen.springboot.demo.manytotmany.entity.Course;
import com.naveen.springboot.demo.manytotmany.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringboardApplication {
    static void main(String[] args) {
        SpringApplication.run(SpringboardApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDao appDao) {
        return runner -> {
            System.out.println("DB Many to Many command line runner");
            System.out.println("DB delete a course then delete all the reviews");

//            createCourseAndStudents(appDao);
//            findCourseAndStudentById(appDao);
//            findStudentAndCourseById(appDao);
//            updateStudent(appDao);
//            deleteCourse(appDao);
            deleteStudent(appDao);

        };
    }

    private void deleteStudent(AppDao appDao){
        int id = 2;
        appDao.deleteStudentById(id);
    }

    private void deleteCourse(AppDao appDao){
        int id = 10;
        appDao.deleteCourseById(id);

    }

    private void updateStudent(AppDao appDao) {
        int id = 2;
        Student student = appDao.findStudentAndCourseByStudentId(id);

        Course course1 = new Course("New course A");
        Course course2 = new Course("New course B");
        Course course3 = new Course("New course C");

        student.addCourse(course1);
        student.addCourse(course2);
        student.addCourse(course3);

        appDao.updateStudent(student);


    }

    private void findStudentAndCourseById(AppDao appDao) {
        int id = 2;
        Student student = appDao.findStudentAndCourseByStudentId(id);
        System.out.println("student: " + student);
        System.out.println("Student courses: " + student.getCourses());

    }

    private void findCourseAndStudentById(AppDao appDao) {
        int id = 10;
        Course course = appDao.findCourseAndStudentByCourseId(id);
        System.out.println("Course: " + course);
        System.out.println("Course students: " + course.getStudents());

    }

    private void createCourseAndStudents(AppDao appDao) {

        Course course = new Course("New course 1");

        Student student1 = new Student("Naveen", "Kumar", "email@gmail.com");
        Student student2 = new Student("Naveen - 2", "Kumar", "email@gmail.com");

        course.addStudent(student1);
        course.addStudent(student2);

        appDao.saveCourseWithStudent(course);
    }
}
