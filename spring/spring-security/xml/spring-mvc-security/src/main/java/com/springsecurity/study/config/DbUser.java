package com.springsecurity.study.config;

import lombok.Data;

@Data
public class DbUser {
	private String username;
	private String password;
	private Integer access;

}
