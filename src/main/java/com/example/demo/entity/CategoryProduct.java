package com.example.demo.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_category")
public class CategoryProduct extends BaseEntity {
	@Column(name = "name", columnDefinition = "nvarchar(250)")
	private String name;
	
	@Column(name = "nameCode", columnDefinition = "nvarchar(250)")
	private String nameCode;
	private Boolean status;
	
	@OneToMany(mappedBy = "categoryProduct")
	@JsonIgnore
	private Set<Product> products;

}
