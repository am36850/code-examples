package com.springsecurity.study.controller;

import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/auth")
public class LoginLogoutController {

	private static final Logger LOGGER = Logger.getLogger("LoginLogoutController");

	@GetMapping("/login")
	public String getLoginPage(@RequestParam(value = "error", required = false) boolean error,
			@RequestParam(value = "logout", required = false) boolean logout,
			@RequestParam(value = "sessionexpired", required = false) boolean sessionexpired,
			@RequestParam(value = "permittedAuthExceeds", required = false) boolean permittedAuthExceeds,
			ModelMap map) {
		LOGGER.info("Login Page requested");
		if (error) {
			map.addAttribute("error", "You have entered invalid username and password!");
		} else {
			map.addAttribute("error", "");
		}
		if (logout) {
			map.addAttribute("logout", "You have been successfully Logged out!");
		} else {
			map.addAttribute("logout", "");
		}
		if (sessionexpired) {
			map.addAttribute("sessionexpired", "Your session has expired!");
		} else {
			map.addAttribute("sessionexpired", "");
		}
		if (permittedAuthExceeds) {
			map.addAttribute("permittedAuthExceeds", "Cocurrent access to the website is blocked for the same user");
		} else {
			map.addAttribute("permittedAuthExceeds", "");
		}
		return "loginpage";

	}

	@GetMapping("/denied")
	public String deniedPage() {
		LOGGER.info("Denied Page requested");
		return "deniedpage";
	}

}
