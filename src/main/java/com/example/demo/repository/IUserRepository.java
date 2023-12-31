package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.User;

public interface IUserRepository extends JpaRepository<User, Long> {

	  @Query(value = "SELECT u FROM User u WHERE u.username = ?1")
	  User findByName(String name);
	  
	  @Query(value = "SELECT u FROM User u WHERE u.email = ?1")
	  User findByEmail(String name);
}
