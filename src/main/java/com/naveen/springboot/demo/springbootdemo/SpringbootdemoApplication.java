package com.naveen.springboot.demo.springbootdemo;

import com.naveen.springboot.demo.springbootdemo.dao.StudentDAO;
import com.naveen.springboot.demo.springbootdemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootdemoApplication.class, args);
	}

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
        return runner ->{
            createStudent(studentDAO);
        };
    }

    private void createStudent(StudentDAO studentDAO) {

        System.out.println("Creating new student object ....");
        Student tempStudent = new Student("Naveen", "Kumar", "naveen@gmail.com");

        System.out.println("Saving the student");
        studentDAO.save(tempStudent);

        System.out.println("Saved student. Generated id: " + tempStudent.getId());
    }

}
