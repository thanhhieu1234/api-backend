package com.example.demo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.OrderDTO;
import com.example.demo.entity.Order;
import com.example.demo.service.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderAPI {

	@Autowired
	private OrderService orderService;

	@GetMapping("/")
	private List<Order> findAll() {
		return orderService.findAll();
	}
	
	@GetMapping("/{id}")
	private Order findOrderByID(@PathVariable Long id) {
		return orderService.findOrderByID(id);
	}


	@PostMapping("/")
	private Order save(@RequestBody OrderDTO dto) {
		return orderService.save(dto);
	}
	
	@PutMapping("/{id}")
	private Order update(@PathVariable Long id , @RequestBody OrderDTO dto) {
		return orderService.update(id, dto);
	}


}
