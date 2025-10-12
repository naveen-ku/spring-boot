package com.naveen.springboot.demo.manytotmany;

import com.naveen.springboot.demo.manytotmany.dao.AppDao;
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

//            saveInstructor(appDao);
//            findInstructorById(appDao);
//            findInstructorDetailsById(appDao);
//            createInstructorWithCourses(appDao);
//            findInstructorWithCourses(appDao);
//            findInstructorWithCoursesJoinFetch(appDao);
//            updateInstructor(appDao);
//            findCourseById(appDao);
//            updateCourseById(appDao);
//            deleteInstructorById(appDao);
//            deleteCourseById(appDao);
//            addCourseToExistingInstructor(appDao);
//            deleteInstructorDetailsById(appDao);

//            createCourseAndReviews(appDao);
//            findCourseWithReviewsByCourseId(appDao);
//            deleteCourseAndReviewsByCourseId(appDao);


        };
    }
}
