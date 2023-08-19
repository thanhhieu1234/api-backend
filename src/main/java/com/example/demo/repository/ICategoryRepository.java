package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.CategoryProduct;

public interface ICategoryRepository extends JpaRepository<CategoryProduct, Long> {
 
	@Query(value = "select c from CategoryProduct c where c.id = ?1")
	public CategoryProduct loadCategoryByID(Long id);
}
