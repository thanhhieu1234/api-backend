package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.CardDTO;
import com.example.demo.dto.OrderDTO;
import com.example.demo.entity.Order;
import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import com.example.demo.service.CardService;

@Controller
public class CardController {
	
	private final String url = "http://localhost:8081/api/order/";
	private RestTemplate restTemplate = new RestTemplate();

	@Autowired
	private CardService cardService;
	
	@Autowired
	private HttpSession session;

	@GetMapping("/product/add-to-cart/{id}")
	private String addToCard(Model model, @PathVariable Long id,@RequestParam(name="quantity") int quantity) {
	    
		cardService.addToCard(id,quantity);
		model.addAttribute("card", cardService.findAll());
		model.addAttribute("total", cardService.getAmount());
		return "client/card";
	}

	@PostMapping("/card/update/{id}")
	private String updateCard(Model model, @PathVariable Long id, @RequestParam("soluong") Integer soluong) {
		cardService.update(id, soluong);
		model.addAttribute("card", cardService.findAll());
		model.addAttribute("total", cardService.getAmount());
		return "client/card";
	}

	@GetMapping("/card/clear")
	private String clearCard(Model model) {
		cardService.clearCard();
		model.addAttribute("card", cardService.findAll());
		model.addAttribute("total", cardService.getAmount());
		return "client/card";
	}

	@GetMapping("/card/delete/{id}")
	private String deleteCard(Model model, @PathVariable Long id) {
		cardService.deleteCard(id);
		model.addAttribute("card", cardService.findAll());
		model.addAttribute("total", cardService.getAmount());
		return "client/card";
	}

	@GetMapping("/checkout")
	private String homeCheckOut(Model model, @ModelAttribute("order") Order order) {
		model.addAttribute("card", cardService.findAll());
		model.addAttribute("total", cardService.getAmount());
		model.addAttribute("checkout", "Thanh toán thành công");
		return "/client/checkout";
	}
	
	@PostMapping("/checkout")
	private String checkOut(Model model, @ModelAttribute("order") OrderDTO order) {
		User user = (User) session.getAttribute("user");
		List<Long> products = new ArrayList<>();
		Double total= cardService.getAmount();
		Collection<CardDTO> cardDTOs = cardService.findAll();
		for (CardDTO cardDTO : cardDTOs) {
			Long id = cardDTO.getProduct().getId();
			order.setQuantity(cardDTO.getQuantity());
			order.setPrice(cardDTO.getProduct().getPrice());
			order.setNameProduct(cardDTO.getProduct().getTitle());
			products.add(id);
		}		
		order.setTotal(total);
		order.setUser(user.getId());
		order.setProducts(products);
		HttpEntity<OrderDTO> entity = new HttpEntity<OrderDTO>(order);
		ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, entity, String.class);
		if(responseEntity.getStatusCode() == HttpStatus.OK) {
			OrderDTO body = entity.getBody();
			cardService.clearCard();
			System.out.println(body);
		}
		
		return "/client/checkout";
	}

}
