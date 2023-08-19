package com.example.demo.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
	
	private Long id;
	private String fullName;
	private String email;
	private String phone;
	private String city;
	private String ward;
	private String address;
	private String payment;
	private String actives;
	private Integer quantity;
	private Double price;
	private String nameProduct;
	private Double total;
	private Long user;
	private List<Long> products;

}
