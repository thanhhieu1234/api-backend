package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.User;

@Controller
public class LoginController {

	private final RestTemplate restTemplate = new RestTemplate();
	
	@GetMapping("/login")
	private String login(@ModelAttribute("user") User user) {
		return "/client/login";
	}
}
