package com.spring.aop.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutConfig {

	@Pointcut("execution(* *.get*()")
	public void getCustomerNamePointcut() {
	}

	@Pointcut("execution(* *.set*(..)")
	public void setCustomerNamePointcut() {
	}

}
