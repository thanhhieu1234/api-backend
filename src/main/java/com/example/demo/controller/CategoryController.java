package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.CategoryProduct;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/admin/quan-li-the-loai")
public class CategoryController {

	private final String url = "http://localhost:8081/api/category/";

	private RestTemplate restTemplate = new RestTemplate();

	private void findAll(Model model) throws JsonMappingException, JsonProcessingException {
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
		if (responseEntity.getStatusCode() == HttpStatus.OK) {
			TypeReference<List<CategoryProduct>> reference = new TypeReference<List<CategoryProduct>>() {
			};
			String body = responseEntity.getBody();
			ObjectMapper mapper = new ObjectMapper();
			List<CategoryProduct> list = mapper.readValue(body, reference);
			model.addAttribute("list", list);
		}
	}

	@GetMapping("")
	private String homeCategory(Model model, @ModelAttribute("categories") CategoryProduct categoryProduct)
			throws JsonMappingException, JsonProcessingException {
		this.findAll(model);
		return "/admin/manage_category";
	}

	@GetMapping("/{id}")
	private String findCategoryByID(Model model, @PathVariable Long id)
			throws JsonMappingException, JsonProcessingException {

		ResponseEntity<String> response = restTemplate.getForEntity(url + id, String.class);
		if (response.getStatusCode() == HttpStatus.OK) {
			ObjectMapper mapper = new ObjectMapper();
			String body = response.getBody();
			CategoryProduct category = mapper.readValue(body, CategoryProduct.class);
			model.addAttribute("categories", category);
			this.findAll(model);
		}
		return "/admin/manage_category";
	}

	@PostMapping("/save")
	private String save(Model model, @ModelAttribute("categories") CategoryProduct categoryProduct)
			throws JsonMappingException, JsonProcessingException {

		HttpEntity<CategoryProduct> entity = new HttpEntity<CategoryProduct>(categoryProduct);
		ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);
		if (response.getStatusCode() == HttpStatus.OK) {
			this.findAll(model);
		}
		return "/admin/manage_category";
	}

	@PostMapping("/update/{id}")
	private String update(Model model, @PathVariable Long id,
			@ModelAttribute("categories") CategoryProduct categoryProduct)
			throws JsonMappingException, JsonProcessingException {
		HttpEntity<CategoryProduct> entity = new HttpEntity<CategoryProduct>(categoryProduct);
		restTemplate.put(url + id, entity);
		this.findAll(model);
		return "/admin/manage_category";
	}

	@GetMapping("/delete/{id}")
	private String delete(Model model, @PathVariable Long id,
			@ModelAttribute("categories") CategoryProduct categoryProduct)
			throws JsonMappingException, JsonProcessingException {
		restTemplate.delete(url + id);
		this.findAll(model);
		return "/admin/manage_category";
	}

}
