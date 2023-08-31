package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Branch;
import com.example.demo.entity.City;
import com.example.demo.entity.District;

public interface IDistrictRepository extends JpaRepository<District, Long> {
 
	@Query(value = "select c from District c where c.city.id = ?1")
	public List<District> loadDistrictByID(Long id);
	
}
