package com.spring.aop.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class SecurityAspect {
	
	@Before("execution(* *.*(..))")
	public void beforeAspect(JoinPoint joinPoint) {
		System.out.println("**************** Success ***************** : From Security Aspect");
		try {
			joinPoint.getArgs();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}


}
