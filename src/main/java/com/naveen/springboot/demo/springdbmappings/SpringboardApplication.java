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
//            deleteInstructorById(appDao);
//            findInstructorDetailsById(appDao);
            deleteInstructorDetailsById(appDao);
        };
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
