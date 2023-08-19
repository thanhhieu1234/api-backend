package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Image;
import com.example.demo.entity.Product;
import com.example.demo.repository.IProductRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class ProductController {

	private final String url = "http://localhost:8081/api/product/";
	private RestTemplate restTemplate = new RestTemplate();

	@GetMapping("/shop")
	private String homeProduct(Model model, @ModelAttribute("product") Product product)
			throws JsonMappingException, JsonProcessingException {
		List<Product> products = this.findAll(model);
		products.forEach(i -> System.out.println(i.getTitle()));
		model.addAttribute("listProduct", products);

		return "/client/shop";
	}

	private List<Product> findAll(Model model) throws JsonMappingException, JsonProcessingException {
		ResponseEntity<String> entity = restTemplate.getForEntity(url, String.class);
		if (entity.getStatusCode() == HttpStatus.OK) {
			String body = entity.getBody();
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Product>> reference = new TypeReference<List<Product>>() {
			};
			List<Product> products = mapper.readValue(body, reference);
			return products;
		}
		return null;
	}

	@GetMapping("/product-details/{id}")
	private String findOneProduct(Model model, @PathVariable Long id)
			throws JsonMappingException, JsonProcessingException {
		ResponseEntity<String> entity = restTemplate.getForEntity(url + id, String.class);
		if (entity.getStatusCode() == HttpStatus.OK) {
			ObjectMapper mapper = new ObjectMapper();
			String body = entity.getBody();
			System.out.println(body);
			Product product = mapper.readValue(body, Product.class);
			model.addAttribute("product", product);
		}
		return "/client/single-product";
	}
	


}
