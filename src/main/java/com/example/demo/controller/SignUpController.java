package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.example.demo.config.WebSecurityConfig;
import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;

@Controller
public class SignUpController {
	private final String url = "http://localhost:8081/api/user/";
	private final RestTemplate restTemplate = new RestTemplate();

	@GetMapping("/sign-up")
	private String signUp(@ModelAttribute("user") User user) {
		return "/client/sign-up";
	}

	@PostMapping("/sign-up")
	private String signUpForm(@ModelAttribute("user") UserDTO user, Model model,@RequestParam("c_password") String pass) {

		HttpEntity<UserDTO> entity = new HttpEntity<UserDTO>(user);

        if(!user.getPassword().equals(pass)) {
			model.addAttribute("mess", "Mật khẩu không trùng khớp");
    		return "/client/sign-up";
        }
		String passString = WebSecurityConfig.passwordEncoder().encode(pass);
		System.out.println(passString);

		List<String> list = Arrays.asList("USER");
		user.setRoles(list);
		user.setPassword(passString);
		
		ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);

		if (response.getStatusCode() == HttpStatus.OK) {
			model.addAttribute("mess", "Đăng ký thành công");
		}
		return "/client/sign-up";
	}

}
