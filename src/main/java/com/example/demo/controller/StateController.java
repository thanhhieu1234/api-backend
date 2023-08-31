package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.City;
import com.example.demo.repository.ICityRepository;
import com.example.demo.repository.IDistrictRepository;

@Controller
public class StateController {

	@Autowired
	ICityRepository cityRepository;

	@Autowired
	IDistrictRepository districtRepository;

	@GetMapping("/state")
	private String list() {
		return "/client/state";
	}

	
	@GetMapping("/city")
	private void list1() {
		List<City> cities = cityRepository.findAll();
		for (City city : cities) {

		}
	}

}
