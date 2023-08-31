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
@Table(name="tbl_city")
public class City extends BaseEntity {
	@Column(name = "nameCity", columnDefinition = "nvarchar(250)")
	private String nameCity;
	
	@JsonIgnore
	@OneToMany(mappedBy = "city")
	private Set<District> districts;
	
}
