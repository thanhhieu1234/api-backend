package com.example.demo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ClientDTO;
import com.example.demo.entity.City;
import com.example.demo.entity.District;
import com.example.demo.entity.Ward;
import com.example.demo.repository.ICityRepository;
import com.example.demo.repository.IDistrictRepository;
import com.example.demo.repository.IWardRepository;
import com.example.demo.service.ClientService;

@RestController
@RequestMapping("/api")
public class StateAPI {

	@Autowired
	ICityRepository cityRepository;

	@Autowired
	IWardRepository wardRepository;
	
	@Autowired
	ClientService clientService;

	@Autowired
	IDistrictRepository districtRepository;

	@GetMapping("/city")
	private List<City> list() {
		return cityRepository.findAll();
	}

	@GetMapping("/district/{id}")
	private List<District> list1(@PathVariable Long id) {
		return districtRepository.loadDistrictByID(id);
	}

	@GetMapping("/ward/{id}")
	private List<Ward> list2(@PathVariable Long id) {
		return wardRepository.loadByWard(id);
	}
	
//	@PostMapping("/create")
//	private String create(@RequestBody ClientDTO clientDTO) {
//		return clientService.clientDTO(clientDTO);
//	}

}
