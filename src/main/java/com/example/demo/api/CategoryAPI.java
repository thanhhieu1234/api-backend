package com.example.demo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CategoryDTO;
import com.example.demo.entity.CategoryProduct;
import com.example.demo.service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryAPI {

	@Autowired
	private CategoryService categoryService;

	@GetMapping("/")
	public List<CategoryProduct> findAll() {
		return categoryService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<CategoryProduct> findOneCategory(@PathVariable Long id) {
		CategoryProduct product = categoryService.findOneByID(id);
		if (product == null) {
			return new ResponseEntity<CategoryProduct>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<CategoryProduct>(product, HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<CategoryProduct> save(@RequestBody CategoryDTO dto) {
		CategoryProduct product = categoryService.save(dto);
		return new ResponseEntity<CategoryProduct>(product, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<CategoryProduct> update(@RequestBody CategoryDTO dto, @PathVariable Long id) {
		CategoryProduct product = categoryService.update(id, dto);
		if (product != null) {
			return new ResponseEntity<CategoryProduct>(product, HttpStatus.OK);
		}
		return new ResponseEntity<CategoryProduct>(HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		categoryService.remove(id);

	}

}
