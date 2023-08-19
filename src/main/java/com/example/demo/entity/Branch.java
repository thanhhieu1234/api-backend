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
@Table(name = "tbl_branch")
public class Branch extends BaseEntity {
	@Column(name = "name", columnDefinition = "nvarchar(250)")
	private String name;

	@Column(name = "nameCode", columnDefinition = "nvarchar(250)")
	private String nameCode;
	private Boolean status;
	
	@Column(name = "logo", columnDefinition = "nvarchar(250)")
	private String logo;

	@JsonIgnore
	@OneToMany(mappedBy = "branch")
	private Set<Product> products;
}
