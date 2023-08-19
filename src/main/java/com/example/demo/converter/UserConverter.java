package com.example.demo.converter;

import org.springframework.stereotype.Component;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;

@Component
public class UserConverter {

	public User toEntity(UserDTO dto) {
		User user = new User();
		user.setUsername(dto.getUsername());
		user.setPassword(dto.getPassword());
		user.setEmail(dto.getEmail());
		user.setPhone(dto.getPhone());
		user.setStatus(dto.getStatus());
		return user;

	}
}
