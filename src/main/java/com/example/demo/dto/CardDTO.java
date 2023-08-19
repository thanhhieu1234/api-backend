package com.example.demo.dto;

import com.example.demo.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardDTO {

	private Product product;
	private Integer quantity;
	
	public void increment() {
		this.quantity++;
	}
}
