package com.naveen.springboot.demo.springddonetomany;


import com.naveen.springboot.demo.springddonetomany.dao.AppDao;
import com.naveen.springboot.demo.springddonetomany.entity.Course;
import com.naveen.springboot.demo.springddonetomany.entity.Instructor;
import com.naveen.springboot.demo.springddonetomany.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringboardApplication {
    static void main(String[] args) {
        SpringApplication.run(SpringboardApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDao appDao) {
        return runner -> {
            System.out.println("DB One to Many command line runner");
//            saveInstructor(appDao);
//            findInstructorById(appDao);
//            deleteInstructorById(appDao);
//            findInstructorDetailsById(appDao);
//            deleteInstructorDetailsById(appDao);
//            createInstructorWithCourses(appDao);
//            findInstructorWithCourses(appDao);
            findInstructorWithCoursesJoinFetch(appDao);
        };
    }

    private void findInstructorWithCoursesJoinFetch(AppDao appDao) {
        System.out.println("---------------------------------------------");
        int id = 1;
        System.out.println("Find findInstructorWithCoursesJoinFetch by id... " + id);
        Instructor instructor = appDao.findInstructorByIdJoinFetchCourses(id);
        System.out.println("instructor by id... " + instructor.toString());
        System.out.println("instructor details... " + instructor.getInstructorDetail());
        System.out.println("instructor courses by... " + instructor.getCourses());

        System.out.println("---------------------------------------------");
    }

    private void findInstructorWithCourses(AppDao appDao) {
        System.out.println("---------------------------------------------");
        int id = 1;
        System.out.println("Find findInstructorWithCourses by id... " + id);
        Instructor instructor = appDao.findInstructorById(id);
        List<Course> courses = appDao.findCoursesByInstructorId(id);
        instructor.setCourses(courses);
        System.out.println("instructor by id... " + instructor.toString());
        System.out.println("instructor details... " + instructor.getInstructorDetail());
        System.out.println("instructor courses by... " + instructor.getCourses());

        System.out.println("---------------------------------------------");
    }

    private void createInstructorWithCourses(AppDao appDao) {
        System.out.println("---------------------------------------------");
        System.out.println("Create instructor & instructorDetails...");
        Instructor instructor = new Instructor("OneToMany", "Kumar", "naveen@gmail.com");
        InstructorDetail instructorDetail = new InstructorDetail("OneToMany", "reading");

        Course course1 = new Course("OneToMany - 1");
        Course course2 = new Course("OneToMany - 2");

        instructor.add(course1);
        instructor.add(course2);

        // associate the objects
        instructor.setInstructorDetail(instructorDetail);

        System.out.println("Saving instructor... " + instructor);
        System.out.println("Saving courses... " + instructor.getCourses());

        appDao.saveInstructor(instructor);
        System.out.println("---------------------------------------------");

    }

    private void deleteInstructorDetailsById(AppDao appDao) {
        int id = 1;
        System.out.println("---------------------------------------------");
        System.out.println("Delete instructorDetails byId... " + id);
        appDao.deleteInstructorDetailById(id);
        System.out.println("---------------------------------------------");
    }

    private void findInstructorDetailsById(AppDao appDao) {
        int id = 1;
        System.out.println("---------------------------------------------");
        System.out.println("Find instructorDetails byId... " + id);
        InstructorDetail instructorDetail = appDao.findInstructorDetailById(id);
        System.out.println("InstructorDetails: " + instructorDetail);
        Instructor instructor = instructorDetail.getInstructor();
        System.out.println("Associated instructor: " + instructor);
        System.out.println("---------------------------------------------");

    }

    private void deleteInstructorById(AppDao appDao) {
        int id = 2;
        System.out.println("---------------------------------------------");
        System.out.println("Delete instructor... " + id);
        appDao.deleteInstructorById(id);
        System.out.println("Deleted instructor... " + id);
        System.out.println("---------------------------------------------");
    }

    private void saveInstructor(AppDao appDao) {
        System.out.println("---------------------------------------------");
        System.out.println("Create instructor & instructorDetails...");
        Instructor instructor = new Instructor("Naveen", "Kumar", "naveen@gmail.com");
        InstructorDetail instructorDetail = new InstructorDetail("techosmic", "reading");

        // associate the objects
        instructor.setInstructorDetail(instructorDetail);

        System.out.println("Saving instructor...");
        appDao.saveInstructor(instructor);
        System.out.println("---------------------------------------------");
    }

    private Instructor findInstructorById(AppDao appDao) {
        System.out.println("---------------------------------------------");
        int id = 1;
        System.out.println("Find instructor by id... " + id);
        Instructor instructor = appDao.findInstructorById(id);
        System.out.println("instructor by id... " + instructor.toString());
        System.out.println("---------------------------------------------");
        return instructor;
    }
}
