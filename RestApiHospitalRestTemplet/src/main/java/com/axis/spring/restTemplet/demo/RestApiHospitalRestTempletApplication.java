package com.axis.spring.restTemplet.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestApiHospitalRestTempletApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiHospitalRestTempletApplication.class, args);
		System.out.println("Application Started");
	}
	
	@Bean
	public RestTemplate getRestTeamplate() {
		return new RestTemplate();
	}

}
