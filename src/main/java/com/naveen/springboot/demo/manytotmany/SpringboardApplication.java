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

            createCourseAndStudents(appDao);


        };
    }

    private void createCourseAndStudents(AppDao appDao) {

        Course course = new Course("New course 1");

        Student student1 = new Student("Naveen", "Kumar","email@gmail.com");
        Student student2 = new Student("Naveen - 2", "Kumar","email@gmail.com");

        course.addStudent(student1);
        course.addStudent(student2);

        appDao.saveCourseWithStudent(course);
    }
}
