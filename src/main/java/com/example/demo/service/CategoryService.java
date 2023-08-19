package com.example.demo.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.converter.CategoryConverter;
import com.example.demo.dto.CategoryDTO;
import com.example.demo.entity.CategoryProduct;
import com.example.demo.repository.ICategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private ICategoryRepository categoryRepository;

	@Autowired
	private CategoryConverter categoryConverter;

	public CategoryProduct save(CategoryDTO dto) {
		CategoryProduct product = categoryConverter.toEntity(dto);
		product.setCreatedDate(new Date());
		return categoryRepository.save(product);
	}

	public CategoryProduct update(Long id, CategoryDTO dto) {
		CategoryProduct product = this.findOneByID(id);
		if (product != null) {
			product.setName(dto.getName());
			product.setNameCode(dto.getNameCode());
			product.setStatus(dto.getStatus());
			product.setModifiedDate(new Date());
			return categoryRepository.save(product);
		}
		return null;
	}

	public List<CategoryProduct> findAll() {
		return categoryRepository.findAll();
	}

	public CategoryProduct findOneByID(Long id) {
		return categoryRepository.findById(id).orElse(null);
	}

	public void remove(Long id) {
		CategoryProduct categoryProduct = this.findOneByID(id);
		categoryRepository.delete(categoryProduct);
	}

}
