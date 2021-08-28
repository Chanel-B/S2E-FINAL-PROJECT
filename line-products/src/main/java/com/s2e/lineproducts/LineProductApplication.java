package com.s2e.lineproducts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class LineProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(LineProductApplication.class, args);
		System.out.println("Line Products Service Running...");
	}

}
