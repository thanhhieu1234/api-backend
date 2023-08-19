package com.example.demo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductAPI {

	@Autowired
	private ProductService productService;

	@GetMapping("/")
	private List<Product> findAll() {
		return productService.findAll();
	}

	@GetMapping("/{id}")
	private Product loadProductByID(@PathVariable Long id) {
		return productService.findOneByID(id);
	}

	@PostMapping("/")
	private ResponseEntity<Product> save(@ModelAttribute ProductDTO dto,
			@RequestParam(name = "file") MultipartFile file, @RequestParam(name = "files") MultipartFile[] files)
			throws Exception {

		Product product = productService.save(dto, file, files);
		if (product == null) {
			return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Product>(product, HttpStatus.OK);

	}
	@PutMapping("/{id}")
	private ResponseEntity<Product> update(@ModelAttribute ProductDTO dto,
			@RequestParam(name = "file") MultipartFile file, @RequestParam(name = "files") MultipartFile[] files,
			@PathVariable Long id)
			throws Exception {

		Product product = productService.update(id, dto, file, files);
		if (product == null) {
			return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Product>(product, HttpStatus.OK);

	}
}
