package com.example.demo.converter;

import org.springframework.stereotype.Component;

import com.example.demo.dto.CategoryDTO;
import com.example.demo.entity.CategoryProduct;

@Component
public class CategoryConverter {

	public CategoryProduct toEntity(CategoryDTO dto) {
		CategoryProduct product = new CategoryProduct();
		product.setName(dto.getName());
		product.setNameCode(dto.getNameCode());
		product.setStatus(dto.getStatus());
		return product;
	}

	public CategoryDTO toDTO(CategoryProduct dto) {
		CategoryDTO product = new CategoryDTO();
		product.setName(dto.getName());
		product.setNameCode(dto.getNameCode());
		product.setStatus(dto.getStatus());
		return product;
	}
}
