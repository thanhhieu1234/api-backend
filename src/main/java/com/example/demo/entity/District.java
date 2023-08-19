package com.example.demo.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tbl_district")
public class District extends BaseEntity {
	@Column(name = "nameDistrict", columnDefinition = "nvarchar(250)")
	private String nameDistrict;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="cityID")
	private City city;
	
	@OneToMany(mappedBy = "district")
	private Set<Ward> wards;
}
