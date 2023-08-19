package com.example.demo.converter;

import org.springframework.stereotype.Component;

import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Product;

@Component
public class ProductConverter {

	public Product toEntity(ProductDTO dto) {
		
		Product product = new Product();
		product.setTitle(dto.getTitle());
		product.setDescription(dto.getDescription());
		product.setDetails(dto.getDetails());
		product.setPrice(dto.getPrice());
		product.setStatus(dto.getStatus());
		product.setHot(dto.getHot());
		product.setViewCount(dto.getViewCount());

		return product;
	}
}
