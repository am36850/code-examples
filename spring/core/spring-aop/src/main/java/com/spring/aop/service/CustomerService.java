package com.spring.aop.service;

import java.util.Objects;

import org.springframework.stereotype.Service;

@Service("customerService")
public class CustomerService {

	private String name = "DummyName";

	public String getCustomerName() {
		return name;
	}

	public String setCustomerName(String name) {
		if (Objects.isNull(name)) {
			throw new IllegalArgumentException("Name can not be null.");
		}
		this.name = name;
		return this.name;
	}

}
