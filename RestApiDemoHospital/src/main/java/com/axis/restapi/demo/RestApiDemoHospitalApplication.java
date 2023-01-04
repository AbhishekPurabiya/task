package com.axis.restapi.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class RestApiDemoHospitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiDemoHospitalApplication.class, args);
		System.out.println("Application Started");
	}

}
