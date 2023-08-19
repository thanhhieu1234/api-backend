package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tbl_ward")
public class Ward extends BaseEntity {
	@Column(name = "nameWard", columnDefinition = "nvarchar(250)")
	private String nameWard;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="districtID")
	private District district;
}
