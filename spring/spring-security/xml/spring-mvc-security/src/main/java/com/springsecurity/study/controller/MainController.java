package com.springsecurity.study.controller;

import java.util.Objects;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainController {

	private static final Logger LOGGER = Logger.getLogger(MainController.class.getName());

	@Autowired(required = false)
	private SessionRegistry sessionRegistry;

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

	@GetMapping("/users")
	public String getUsersDetails(Model model) {
		LOGGER.info("Received request to show users page");
		if (Objects.isNull(sessionRegistry)) {
			return "userspage";
		}		
		model.addAttribute("users", sessionRegistry.getAllPrincipals());
		model.addAttribute("total", sessionRegistry.getAllPrincipals().size());
		return "userspage";
	}

}
