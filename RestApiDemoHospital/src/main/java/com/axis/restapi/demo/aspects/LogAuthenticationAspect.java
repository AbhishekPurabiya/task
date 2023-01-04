package com.axis.restapi.demo.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAuthenticationAspect {

	@Before("execution(* com.axis.restapi.demo.controller.*.*(..))")
	public void logging() {
		System.out.println("User Loging.....");
	}
	
	@After("execution(* com.axis.restapi.demo.controller.*.*(..))")
	public void logout() {
		System.out.println("User Logout.....");
	}
}
