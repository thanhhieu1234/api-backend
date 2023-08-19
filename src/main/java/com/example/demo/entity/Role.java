package com.example.demo.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tbl_role")
public class Role extends BaseEntity {
	@Column(name = "name", columnDefinition = "nvarchar(250)")
	private String name;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "roles")
	private List<User> users;
}
