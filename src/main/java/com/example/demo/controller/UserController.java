package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.repository.IRoleRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class UserController {

	@Autowired
	private IRoleRepository roleRepository;

	private final String url = "http://localhost:8081/api/user/";

	private RestTemplate restTemplate = new RestTemplate();

	@GetMapping("/admin/quan-li-tai-khoan")
	private String index(Model model, @ModelAttribute("user") User user)
			throws JsonMappingException, JsonProcessingException {
		this.findAll(model);
		return "/admin/manage_account";
	}

	private void findAll(Model model) throws JsonMappingException, JsonProcessingException {
		ResponseEntity<String> entity = restTemplate.getForEntity(url, String.class);
		if (entity.getStatusCode() == HttpStatus.OK) {
			String body = entity.getBody();
			TypeReference<List<User>> reference = new TypeReference<List<User>>() {
			};
			ObjectMapper mapper = new ObjectMapper();
			List<User> list = mapper.readValue(body, reference);
			list.forEach(i -> {
				model.addAttribute("list", list);
			});
			model.addAttribute("roles", roleRepository.findAll());
		}
	}

	@GetMapping("/search/{id}")
	private String findOne(@PathVariable Long id, Model model) throws JsonMappingException, JsonProcessingException {
		ResponseEntity<String> entity = restTemplate.getForEntity(url + id, String.class);
		if (entity.getStatusCode() == HttpStatus.OK) {
			ObjectMapper mapper = new ObjectMapper();
			String body = entity.getBody();

			User u = mapper.readValue(body, User.class);
			model.addAttribute("user", u);
			this.findAll(model);
		}
		return "/admin/manage_account";
	}

	@PostMapping("/update/{id}")
	private String update(@PathVariable Long id, Model model, @ModelAttribute("user") UserDTO user,
			@RequestParam(name = "check") List<String> name) throws JsonMappingException, JsonProcessingException {
		user.setRoles(name);
		for (String long1 : user.getRoles()) {
			System.out.println("long " + long1);
		}
		HttpEntity<UserDTO> entity = new HttpEntity<UserDTO>(user);
		restTemplate.put(url + id, entity);
		this.findAll(model);
		return "/admin/manage_account";
	}

	@PostMapping("/save")
	private String save(Model model, @ModelAttribute("user") UserDTO user,
			@RequestParam(name = "check") List<String> name) throws JsonMappingException, JsonProcessingException {
		user.setRoles(name);
		HttpEntity<UserDTO> entity = new HttpEntity<UserDTO>(user);
		ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, entity, String.class);
		if (responseEntity.getStatusCode() == HttpStatus.OK) {
			this.findAll(model);
		}
		return "/admin/manage_account";
	}
}
