package com.spring.aop.manual;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.aop.config.AspectConfig;
import com.spring.aop.config.SecurityAspect;

@Configuration
public class BeanConfiguration {
	
	@Bean
	public AspectConfig getAspectConfig() {
		return new AspectConfig();
	}
	
	@Bean
	public SecurityAspect securityAspect() {
		return new SecurityAspect();
	}

}
