package com.VaccinationCenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableCircuitBreaker
public class MicroServiceVaccinationCenter1Application {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceVaccinationCenter1Application.class, args);
	}
	
	@Bean
//	@LoadBalanced
	public RestTemplate geRestTemplate() {
		
		return new RestTemplate();
	}

}
