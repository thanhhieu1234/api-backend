package com.example.demo.service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CardDTO;
import com.example.demo.entity.Product;
import com.example.demo.repository.IProductRepository;

@Service
public class CardService {

	@Autowired
	IProductRepository productRepository;

	private Map<Long, CardDTO> map = new HashMap<>();

	public CardDTO addToCard(Long id, String quantity) {
		Product product = productRepository.findById(id).get();
		CardDTO cardDTO = new CardDTO();
		boolean check = map.containsKey(id);
		int soLuong = Integer.parseInt(quantity);
		if (check == false) {
			cardDTO = new CardDTO();
			cardDTO.setQuantity(soLuong);
			cardDTO.setProduct(product);
			map.put(id, cardDTO);
			System.out.println(cardDTO.getQuantity());
		} else {
			cardDTO = this.findByID(id);
			cardDTO.increment();
			cardDTO.setProduct(product);
			System.out.println(cardDTO.getQuantity());
			map.put(id, cardDTO);
		}
		return cardDTO;
	}

	public CardDTO findByID(Long id) {
		if (map.containsKey(id)) {
			return map.get(id);
		}
		return null;
	}

	public Collection<CardDTO> findAll() {
		return map.values();
	}

	public Double getAmount() {
		double total = 0;
		for (Map.Entry<Long, CardDTO> entry : map.entrySet()) {
			CardDTO val = entry.getValue();
			Integer quantity = val.getQuantity();
			Double price = val.getProduct().getPrice();
			total += quantity * price;
		}
		return total;
	}

	public CardDTO update(Long id, Integer soluong) {
		CardDTO dto = this.findByID(id);
		if (dto == null) {
			return null;
		}
		dto.setQuantity(soluong);
		map.put(id, dto);
		return dto;
	}

	public void clearCard() {
		map.clear();
	}

	public void deleteCard(Long id) {
		if (map.containsKey(id)) {
			map.remove(id);
		}
	}

}
