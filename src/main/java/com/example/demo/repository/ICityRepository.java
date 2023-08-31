package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Branch;
import com.example.demo.entity.City;

public interface ICityRepository extends JpaRepository<City, Long> {
 
	
}
