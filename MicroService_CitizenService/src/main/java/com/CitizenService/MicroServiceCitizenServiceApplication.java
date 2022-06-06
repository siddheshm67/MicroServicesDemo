package com.CitizenService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication
public class MicroServiceCitizenServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceCitizenServiceApplication.class, args);
	}

}
