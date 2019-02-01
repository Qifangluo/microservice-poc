package com.example.mspoc.mspocstudentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MspocStudentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MspocStudentServiceApplication.class, args);
	}

}

