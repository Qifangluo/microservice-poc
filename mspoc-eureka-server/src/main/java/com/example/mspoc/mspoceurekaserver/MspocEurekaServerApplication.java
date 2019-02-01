package com.example.mspoc.mspoceurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MspocEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MspocEurekaServerApplication.class, args);
	}

}

