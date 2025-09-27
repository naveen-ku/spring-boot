package com.naveen.springboot.demo.restcrud.controller;


import com.naveen.springboot.demo.restcrud.entity.Student;
import com.naveen.springboot.demo.restcrud.entity.StudentErrorResponse;
import com.naveen.springboot.demo.restcrud.exception.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    @PostConstruct
    public void loadData(){
        students = new ArrayList<>();
        students.add(new Student("Naveen", "Kumar"));
        students.add(new Student("Satish", "Upadhyay"));
        students.add(new Student("Aayush", "Gupta"));
        students.add(new Student("Saarthak", "Gupta"));
    }

//     define endpoint for "/students" - return list of students
    @GetMapping("/students")
    public List<Student> getStudents(){
//         populate students...
//        List<Student> students =dummyStudentData();
        return students;
    }

//     define endpoint for "/students/{studentId}" - return student at index,
//     the PathVariable name must match with parameter
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

//         populate students
//        List<Student> students = dummyStudentData();

        if(studentId >= students.size() || studentId < 0){
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }

        return students.get(studentId);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

//    private List<Student> dummyStudentData(){
//        List<Student> students = new ArrayList<>();
//        students.add(new Student("Naveen", "Kumar"));
//        students.add(new Student("Satish", "Upadhyay"));
//        students.add(new Student("Aayush", "Gupta"));
//        students.add(new Student("Saarthak", "Gupta"));
//        return students;
//    }

}
