package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Order;

public interface IOrderRepository extends JpaRepository<Order, Long> {

}
