package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	UserService service;

	@GetMapping("/login")
	private String login() {
		return "/client/login";
	}
	
	@GetMapping("/oauth2/login/success")
	private String loginSuccess(Model model,OAuth2AuthenticationToken accessToken) throws Exception {
		service.createOAuth2(accessToken);
		model.addAttribute("mess", "Dang nhap thanh cong");
		return "/client/login";
	}
	
	@GetMapping("/logoutURL")
	private String logout(Model model) {
		model.addAttribute("mess", "Dang xuat thanh cong");

		return "/client/login";
	}
	
	@GetMapping("/oauth2/login/fail")
	private String LoginFail() {
		return "/client/sign-up";
	}

}
