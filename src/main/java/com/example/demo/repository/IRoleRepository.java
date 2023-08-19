package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Role;

public interface IRoleRepository extends JpaRepository<Role, Long> {

	public Role findOneByName(String name);
	
	
}
