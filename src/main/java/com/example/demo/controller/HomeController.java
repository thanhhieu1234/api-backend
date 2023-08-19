package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.User;

@Controller
public class HomeController {

	@GetMapping("/index")
	String homeIndex() {
		return "/client/index";
	}

	@GetMapping("/admin")
	String homeAdmin() {
		return "/admin/dash_board";
	}
	

}
