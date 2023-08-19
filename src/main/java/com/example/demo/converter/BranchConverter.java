package com.example.demo.converter;

import org.springframework.stereotype.Component;

import com.example.demo.dto.BranchDTO;
import com.example.demo.entity.Branch;

@Component
public class BranchConverter {

	public Branch toEntity(BranchDTO dto) {
		Branch branch = new Branch();
		branch.setName(dto.getName());
		branch.setNameCode(dto.getNameCode());
		branch.setStatus(dto.getStatus());
		branch.setLogo(dto.getLogo());
//		product.setCreatedDate(dto.getCreatedDate());

		return branch;
	}
}
