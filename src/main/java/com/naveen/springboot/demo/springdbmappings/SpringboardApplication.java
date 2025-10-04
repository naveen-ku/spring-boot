package com.naveen.springboot.demo.springdbmappings;


import com.naveen.springboot.demo.springdbmappings.dao.AppDao;
import com.naveen.springboot.demo.springdbmappings.entity.Instructor;
import com.naveen.springboot.demo.springdbmappings.entity.InstructorDetail;
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
            System.out.println("DB Mappings command line runner");
//            saveInstructor(appDao);
//            findInstructorById(appDao);
            deleteInstructorById(appDao);
        };
    }

    private void deleteInstructorById(AppDao appDao) {
        int id = 2;
        System.out.println("Delete instructor... " + id);
        appDao.deleteInstructorById(id);
        System.out.println("Deleted instructor... " + id);
    }

    private void saveInstructor(AppDao appDao) {
        System.out.println("Create instructor & instructorDetails...");
        Instructor instructor = new Instructor("Naveen", "Kumar", "naveen@gmail.com");
        InstructorDetail instructorDetail = new InstructorDetail("techosmic", "reading");

        // associate the objects
        instructor.setInstructorDetail(instructorDetail);

        System.out.println("Saving instructor...");
        appDao.saveInstructor(instructor);
    }

    private Instructor findInstructorById(AppDao appDao) {
        int id = 1;
        System.out.println("Find instructor by id... " + id);
        Instructor instructor = appDao.findInstructorById(id);
        System.out.println("instructor by id... " + instructor.toString());
        return instructor;
    }
}
