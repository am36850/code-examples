package com.springsecurity.study.controller;

import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainController {
	
	private static final Logger LOGGER = Logger.getLogger(MainController.class.getName());
	
	@GetMapping("/common")
	public String commonPage() {
		LOGGER.info("Requested common page");
		return "commonpage";	
	}
	
	@GetMapping("/admin")
	public String adminPage() {
		LOGGER.info("Requested Admin Page");
		return "adminpage";
	}	

}
