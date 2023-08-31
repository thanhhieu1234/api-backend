package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;
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
@Table(name="tbl_user")
public class User extends BaseEntity {
   
	@Column(name = "username", columnDefinition = "nvarchar(250)")
	private String username;
	
	@Column(name = "password", columnDefinition = "nvarchar(250)")
	private String password;
	
	@Column(name = "email", columnDefinition = "nvarchar(250)")
	private String email;
	
	@Column(name = "phone", columnDefinition = "nvarchar(250)")
	private String phone;
	private Boolean status;
	
	private String otp;
	private LocalDateTime dateTime;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(
	name = "tbl_user_role",
	joinColumns = {@JoinColumn (name= "fk_user")},
	inverseJoinColumns = {@JoinColumn(name="fk_role")}
			)
	private List<Role> roles;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private Set<Order> orders;
}
