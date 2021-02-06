package com.example.springsecuritydemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@GetMapping("/home")
	public String home() {
		return "This is home page!";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "You are admin user!";
	}
	
	@GetMapping("/client")
	public String client() {
		return "You are client user!";
	}
}
