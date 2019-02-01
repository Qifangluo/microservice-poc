package com.example.mspoc.mspoccourseservice.service;

import com.example.mspoc.mspoccourseservice.model.Student;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StudentRegistrationDelegate {

    @Autowired
    RestTemplate restTemplate;

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @HystrixCommand(fallbackMethod = "getStudentByIdFallback")
    public Student getStudentById(int id){
        String url = "http://student-service/students/" + id;
        Student student = restTemplate.getForObject(url, Student.class);
        return student;
    }

    @SuppressWarnings("unused")
    public Student getStudentByIdFallback(int id){
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<  Fall back method is called  >>>>>>>>>>>>>>>>>>>>>");
        return new Student(id, "Error finding student with id = " + id, "Not Available");
    }


    //Ribbon
    public String getRibbonServerResponse(){
        String result = restTemplate.getForObject("http://student-service/ribbonserver", String.class);
        return "Response Getting from server >>>> " + result;
    }
}

