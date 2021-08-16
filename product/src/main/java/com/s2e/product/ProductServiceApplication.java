package com.s2e.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
		System.out.println("Product service running now...");
	}

	/**
	 * facciamo la injection
	 * chiamando products
	 * configurazione automatico
	 * let go to controller to continue
	 */
	@Bean
	//
	RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
