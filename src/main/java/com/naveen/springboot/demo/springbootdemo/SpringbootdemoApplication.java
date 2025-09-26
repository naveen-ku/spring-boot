package com.naveen.springboot.demo.springbootdemo;

import com.naveen.springboot.demo.springbootdemo.dao.StudentDAO;
import com.naveen.springboot.demo.springbootdemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringbootdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootdemoApplication.class, args);
	}

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
        return runner ->{
            createStudent(studentDAO);
            createMultipleStudent(studentDAO);
//            readStudent(studentDAO);
//            queryForStudents(studentDAO);
//            queryForStudentsByLastName(studentDAO);
//            updateStudent(studentDAO);
//            deleteStudent(studentDAO);
//            deleteAllStudent(studentDAO);
        };
    }

    private void createStudent(StudentDAO studentDAO) {

        System.out.println("Creating new student object ....");
        Student tempStudent = new Student("Naveen", "Kumar", "naveen@gmail.com");

        System.out.println("Saving the student");
        studentDAO.save(tempStudent);

        System.out.println("Saved student. Generated id: " + tempStudent.getId());
    }

    private void createMultipleStudent(StudentDAO studentDAO){
        System.out.println("Creating 4 student object ....");
        Student tempStudent1 = new Student("Aayush", "Gupta", "naveen@gmail.com");
        Student tempStudent2 = new Student("Saarthak", "Gupta", "saarthak@gmail.com");
        Student tempStudent3 = new Student("Manas", "Sahai", "manas@gmail.com");
        Student tempStudent4 = new Student("Satish", "Upadhyay", "satish@gmail.com");

        System.out.println("Saving the students...");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);
        studentDAO.save(tempStudent4);

        System.out.println("Saved student. Generated id: " + tempStudent1.getId());
        System.out.println("Saved student. Generated id: " + tempStudent2.getId());
        System.out.println("Saved student. Generated id: " + tempStudent3.getId());
        System.out.println("Saved student. Generated id: " + tempStudent4.getId());

    }

    private void readStudent(StudentDAO studentDAO) {

        System.out.println("Read student object ....");

        System.out.println("Getting the student");
        Student student = studentDAO.findById(1);

        System.out.println("Found student: " + student);
    }

    private void queryForStudents(StudentDAO studentDAO){
        List<Student> students = studentDAO.findAll();

        for(Student tempStudent: students){
            System.out.println(tempStudent);
        }
    }

    private void queryForStudentsByLastName(StudentDAO studentDAO){
        List<Student> students = studentDAO.findByLastName("Gupta");

        for(Student tempStudent: students){
            System.out.println(tempStudent);
        }
    }

    private void updateStudent(StudentDAO studentDAO){
        int sId = 1;
        System.out.println("Getting the student with id: " + sId);
        Student student = studentDAO.findById(sId);
        System.out.println("Updating student..." + student);

        if(student != null){
            student.setFirstName("Naveen");
            studentDAO.update(student);
            System.out.println("Updated student: " + student);
        }
    }

    private void deleteStudent(StudentDAO studentDAO){
        int studentId = 1;
        System.out.println("Deleting student with id: " + studentId);
        studentDAO.delete(studentId);
    }

    private void deleteAllStudent(StudentDAO studentDAO){
        System.out.println("Deleting all student...");
        int numRowsDeleted = studentDAO.deleteAll();
        System.out.println("Deleted rows..." + numRowsDeleted);

    }

}
