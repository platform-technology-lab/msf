package com.platformtechlab.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient 
@SpringBootApplication
public class SpringBootEmployeeApplication {
	 
    public static void main(String[] args) {
        SpringApplication.run(SpringBootEmployeeApplication.class, args);
    }
}
