package com.example.demo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.RegisterDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.service.MailService;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserAPI {

	@Autowired
	private UserService userService;

	@Autowired
	MailService mailService;

	@GetMapping("/")
	private List<User> findAll() {
		return userService.findAll();
	}

	@GetMapping("/{id}")
	private User findOneUser(@PathVariable Long id) {
		return userService.findUserByID(id);
	}

	@PostMapping("/")
	private User save(@RequestBody UserDTO dto) {
		return userService.save(dto);
	}

	@PostMapping("/create")
	private String save1(@RequestBody RegisterDTO dto) {
		return mailService.create(dto);
	}

	@PostMapping("/verify")
	private String verify(@RequestParam("email") String email, @RequestParam("otp") String otp) {
		return mailService.verifyOTP(email, otp);
	}
	
	@PostMapping("/refresh")
	private String refresh(@RequestParam("email") String email) {
		return mailService.createdOTP(email);
	}

	@PutMapping("/{id}")
	private User update(@RequestBody UserDTO dto, @PathVariable Long id) {
		return userService.update(dto, id);
	}

}
