package com.example.demo.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_product")
public class Product extends BaseEntity {
	@Column(name = "title", columnDefinition = "nvarchar(250)")
	private String title;

	@Column(name = "description", columnDefinition = "nvarchar(250)")
	private String description;

	@Column(name = "details", columnDefinition = "nvarchar(250)")
	private String details;

	private Double price;
	private Boolean status;
	private Integer hot;
	
	@Column(name = "image", columnDefinition = "nvarchar(250)")
	private String image;
	private Long viewCount;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="categoryID")
	private CategoryProduct categoryProduct;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="branchID")
	private Branch branch;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(
	name = "tbl_product_image",
	joinColumns = {@JoinColumn (name= "fk_product")},
	inverseJoinColumns = {@JoinColumn(name="fk_image")}
			)
	private List<Image> images;
	
	
	@ManyToMany(mappedBy = "products")
	@JsonIgnore
	private List<Order> orders;

}
