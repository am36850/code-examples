package com.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.aop.config.SpringConfig;
import com.spring.aop.service.CustomerService;

public class App {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		CustomerService customerService = context.getBean("customerService", CustomerService.class);
		System.out.println("Default Customer :" + customerService.getCustomerName());
		customerService.setCustomerName("Anant Mane");
		System.out.println("Changed Customer :" + customerService.getCustomerName());
		try {
			customerService.setCustomerName(null);
		} catch (Exception e) {
			System.out.println("Exception raised:" + e.getMessage());
		}
		System.out.println("Changed Customer Name with null:" + customerService.getCustomerName());
		context.close();
	}
}
