package com.example.mspoc.mspocstudentservice.controller;

import com.example.mspoc.mspocstudentservice.model.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.mspoc.mspocstudentservice.dao.StudentDAO.studentDB;

@RestController
public class StudentController {


    private String message;

    @GetMapping("/allStudents")
    public List<Student> getAllStudents(){
        return studentDB;
    }

    @GetMapping("/emailStudents")
    public void emailAllStudents(){
        System.out.println(this.message);
    }

    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable int id){
        List<Student> list = studentDB.stream().filter((student) -> student.getId() == id)
                .collect(Collectors.toList());
        return list.get(0);
    }

    //ribbon load balancer
    @Autowired
    Environment environment;

    @GetMapping("/ribbonserver")
    public String GetRibbonStatus(){
        String serverPort = environment.getProperty("local.server.port");
        return "Hello from Student Service at localhost:" + serverPort;
    }
}
