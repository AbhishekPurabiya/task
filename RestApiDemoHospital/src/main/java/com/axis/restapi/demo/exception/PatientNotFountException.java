package com.axis.restapi.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice
@Component
public class PatientNotFountException extends Exception{

	private String error ;
	
	public PatientNotFountException() {
		super();
	}
	
	public PatientNotFountException(String error) {
		super();
		this.error = error;
	}
}
