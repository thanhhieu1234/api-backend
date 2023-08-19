package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
	private String title;
	private String description;
	private String details;
	private Double price;
	private Boolean status;
	private Integer hot;
	private Long viewCount;
	private Long categoryProduct;
	private Long branch;

}
