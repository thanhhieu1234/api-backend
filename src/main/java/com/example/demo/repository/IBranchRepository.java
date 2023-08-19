package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Branch;

public interface IBranchRepository extends JpaRepository<Branch, Long> {
 
	@Query(value = "select c from Branch c where c.id = ?1")
	public Branch loadBranchByID(Long id);
	
}
