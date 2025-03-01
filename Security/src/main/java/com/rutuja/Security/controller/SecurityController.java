package com.rutuja.Security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/security")
public class SecurityController {
	
	@GetMapping("/public")
	public String publicall()
	{
		return "Hello, Public API";
	}

	@GetMapping("/user")
	public String userall() {
		return "Hello, User API";
	}
	
	@GetMapping("/admin")
	public String adminall()
	{
		return "Hello,Admin API";
	}
}
