package com.example.demo.converter;

import org.springframework.stereotype.Component;

import com.example.demo.dto.OrderDTO;
import com.example.demo.entity.Order;

@Component
public class OrderConverter {

	public Order toEntity(OrderDTO dto) {		
		Order order = new Order();
		order.setFullName(dto.getFullName());
		order.setEmail(dto.getEmail());
		order.setPhone(dto.getPhone());
		order.setCity(dto.getCity());
		order.setWard(dto.getWard());
		order.setCity(dto.getCity());
		order.setAddress(dto.getAddress());
		order.setPayment(dto.getPayment());
		order.setFullName(dto.getFullName());
		order.setActives(dto.getActives());
		return order;
	}
}
