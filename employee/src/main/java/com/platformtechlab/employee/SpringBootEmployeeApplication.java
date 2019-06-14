package com.platformtechlab.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@EnableDiscoveryClient 
@SpringBootApplication
public class SpringBootEmployeeApplication {
	 
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    public static void main(String[] args) {
        SpringApplication.run(SpringBootEmployeeApplication.class, args);
    }
}
