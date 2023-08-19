package com.example.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.converter.OrderConverter;
import com.example.demo.dto.OrderDTO;
import com.example.demo.entity.Order;
import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import com.example.demo.repository.IOrderRepository;
import com.example.demo.repository.IProductRepository;
import com.example.demo.repository.IUserRepository;

@Service
public class OrderService {

	@Autowired
	private IOrderRepository iOrderRepository;

	@Autowired
	private IProductRepository iProductRepository;

	@Autowired
	private OrderConverter orderConverter;

	@Autowired
	private IUserRepository iUserRepository;

	public Order save(OrderDTO dto) {
		User user = iUserRepository.findById(dto.getUser()).get();
		List<Product> products = this.findAllByID(dto);

		Order order = orderConverter.toEntity(dto);
		order.setDateBuy(new Date());
		order.setProducts(products);
		order.setUser(user);

		return iOrderRepository.save(order);
	}

	public Order update(Long id, OrderDTO dto) {
		Order order = this.findOrderByID(id);
		if(order == null) {
			return null;
		}
		
		User user = iUserRepository.findById(dto.getUser()).get();
		List<Product> products = this.findAllByID(dto);
		order.setDateBuy(new Date());
		order.setProducts(products);
		order.setUser(user);
		order.setFullName(dto.getFullName());
		order.setEmail(dto.getEmail());
		order.setPhone(dto.getPhone());
		order.setCity(dto.getCity());
		order.setWard(dto.getWard());
		order.setAddress(dto.getAddress());
		order.setPayment(dto.getPayment());
		order.setActives(dto.getActives());
		return iOrderRepository.save(order);
	}

	public List<Product> findAllByID(OrderDTO orderDTO) {
		List<Product> products = new ArrayList<>();
		for (Long id : orderDTO.getProducts()) {
			System.out.println("id " + id);
			Product product = iProductRepository.findById(id).orElse(null);
			products.add(product);
		}

		return products;
	}

	public List<Order> findAll() {
		return iOrderRepository.findAll();
	}

	public Order findOrderByID(Long id) {
		return iOrderRepository.findById(id).orElse(null);
	}

}
