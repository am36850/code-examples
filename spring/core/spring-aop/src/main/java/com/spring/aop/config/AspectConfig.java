package com.spring.aop.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AspectConfig {

	@Before(value = "com.spring.aop.config.PointcutConfig.getCustomerNamePointcut()")
	public void beforeGetCustomerName() {
		System.out.println("Before Aspect:: Get Customer Name");
	}

	@AfterReturning(value = "com.spring.aop.config.PointcutConfig.getCustomerNamePointcut()", returning = "retValue")
	public void afterReturningGetCustomerName(Object retValue) {
		System.out.println("After Returning Aspect:: Returned Value ::" + retValue);
	}

	@After(value = "com.spring.aop.config.PointcutConfig.getCustomerNamePointcut()")
	public void afterGetCustomerName() {
		System.out.println("After Aspect::");
	}

	@Before(value = "com.spring.aop.config.PointcutConfig.setCustomerNamePointcut()", argNames = "name")
	public void beforeSetCustomerName(String name) {
		System.out.println("Before Aspect:: Set Customer Name :: Parameter passed ::" + name);
	}

	@AfterThrowing(value = "com.spring.aop.config.PointcutConfig.setCustomerNamePointcut()", throwing = "ex")
	public void afterThrowingSetCustomerName(Exception ex) {
		System.out.println("After Throwing Aspect:: Set Customer Name :: Exception ::" + ex.getMessage());
	}

	@After(value = "com.spring.aop.config.PointcutConfig.setCustomerNamePointcut()")
	public void afterSetCustomerName() {
		System.out.println("After Aspect:: Set Customer Name");
	}

	@Around(value = "com.spring.aop.config.PointcutConfig.setCustomerNamePointcut()", argNames = "name")
	public void aroundSetCustomerName(ProceedingJoinPoint joinPoint, Object name) {
		System.out.println("Around Aspect:: Set Customer Name :: Before :: Arg name :" + name);
		try {
			Object object = joinPoint.proceed();
			System.out.println("Around Aspect:: Set Customer Name :: After :: Returned :" + object);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
