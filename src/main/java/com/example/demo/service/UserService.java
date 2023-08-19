package com.example.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.converter.UserConverter;
import com.example.demo.dto.UserDTO;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.repository.IRoleRepository;
import com.example.demo.repository.IUserRepository;

@Service
public class UserService {
	@Autowired
	private IUserRepository iUserRepository;

	@Autowired
	private IRoleRepository iRoleRepository;

	@Autowired
	private UserConverter converter;

	public List<User> findAll() {
		return iUserRepository.findAll();
	}

	public User findUserByID(Long id) {
		return iUserRepository.findById(id).orElse(null);
	}

	public User save(UserDTO dto) {
		List<Role> set = new ArrayList<>();
		for (String role : dto.getRoles()) {
			Role role2 = iRoleRepository.findOneByName(role);
			set.add(role2);
		}
		User user = converter.toEntity(dto);
		user.setRoles(set);
		return iUserRepository.save(user);
	}

	public User update(UserDTO dto, Long id) {
		User user = iUserRepository.findById(id).orElse(null);
		if (user == null) {
			return null;
		}
		List<Role> set = new ArrayList<>();
		for (String role : dto.getRoles()) {
			Role role2 = iRoleRepository.findOneByName(role);
			set.add(role2);
		}
		user.setRoles(set);
		user.setUsername(dto.getUsername());
		user.setEmail(dto.getEmail());
		user.setPassword(dto.getPassword());
		user.setPhone(dto.getPhone());
		user.setStatus(dto.getStatus());

		return iUserRepository.save(user);
	}
	


}
