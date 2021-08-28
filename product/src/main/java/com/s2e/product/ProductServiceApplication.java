package com.s2e.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient  //because is this ms that is going to connect to ther service class
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
		System.out.println("Product service running now...");
	}

	/**
	 * facciamo la injection
	 * c@Bean
	 * 	//
	 * 	Resthiamando products
	 * configurazione automatico
	 * let go to controller to continue
	 */
	@Bean
	RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
