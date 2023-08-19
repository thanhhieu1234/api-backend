package com.example.demo.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_order")
public class Order extends BaseEntity {

	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private Date dateBuy;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userID")
	private User user;

	@Column(name = "fullName", columnDefinition = "nvarchar(250)")
	private String fullName;
	
	@Column(name = "email", columnDefinition = "nvarchar(250)")
	private String email;
	
	@Column(name = "phone", columnDefinition = "nvarchar(250)")
	private String phone;
	
	@Column(name = "city", columnDefinition = "nvarchar(250)")
	private String city;
	
	@Column(name = "ward", columnDefinition = "nvarchar(250)")
	private String ward;
	
	@Column(name = "address", columnDefinition = "nvarchar(250)")
	private String address;
	private Double price;
	
	@Column(name = "nameproduct", columnDefinition = "nvarchar(250)")
	private String nameproduct;
	private Integer quantity;
	
	@Column(name = "payment", columnDefinition = "nvarchar(250)")
	private String payment;
	
	@Column(name = "actives", columnDefinition = "nvarchar(250)")
	private String actives;
	
	private Double total; 
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
	name = "tbl_product_details",
	joinColumns = {@JoinColumn (name= "fk_order")},
	inverseJoinColumns = {@JoinColumn(name="fk_product")}
			)
	private List<Product> products;

}
