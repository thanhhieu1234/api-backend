package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
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

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	private HttpSession session;

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

	public void createOAuth2(OAuth2AuthenticationToken accessToken) throws Exception {
		// TODO Auto-generated method stub
		String email = accessToken.getPrincipal().getAttribute("email");
		UserDetails details = org.springframework.security.core.userdetails.User.withUsername(email)
				.password(encoder.encode("123")).roles("GOEST").build();
		System.out.println("Detai " + email + details.getUsername() + details.getAuthorities());
		Authentication authentication = new UsernamePasswordAuthenticationToken(details, null,
				details.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
		User u = iUserRepository.findByEmail(email);
		if (u == null) {

			User user = new User();
			user.setEmail(details.getUsername());
			user.setDateTime(LocalDateTime.now());
			List<Role> list = new ArrayList<>();
			Role role = new Role();
			role.setName("GOEST");
			iRoleRepository.save(role);
			list.add(role);
			user.setRoles(list);
			session.setAttribute("user", user);
			iUserRepository.save(user);
		} else {
			session.setAttribute("user", u);
		}

		// user.set
	}

}
