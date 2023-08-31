package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Branch;
import com.example.demo.entity.City;
import com.example.demo.entity.Ward;

public interface IWardRepository extends JpaRepository<Ward, Long> {

	@Query(value = "select w from Ward w where w.district.id= ?1")
	public List<Ward> loadByWard(Long id);
}
