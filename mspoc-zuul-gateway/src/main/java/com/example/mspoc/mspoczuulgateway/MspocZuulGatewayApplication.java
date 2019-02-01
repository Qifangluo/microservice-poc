package com.example.mspoc.mspoczuulgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
@EnableEurekaClient
//EnableDiscoveryClient contains multiple types of clients.. Eureka is one of them (EnableEurekaClient)
public class MspocZuulGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MspocZuulGatewayApplication.class, args);
	}

}

