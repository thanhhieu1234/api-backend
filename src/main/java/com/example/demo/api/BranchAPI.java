package com.example.demo.api;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.BranchDTO;
import com.example.demo.entity.Branch;
import com.example.demo.service.BranchService;

@RestController
@RequestMapping("/api/branch")
public class BranchAPI {

	@Autowired
	private BranchService branchService;

	@GetMapping("/")
	public List<Branch> findAll() {
		return branchService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Branch> findOneCategory(@PathVariable Long id) {
		Branch branch = branchService.findOneByID(id);
		if (branch == null) {
			return new ResponseEntity<Branch>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Branch>(branch, HttpStatus.OK);
	}

	@PostMapping(value = "/", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Branch> save(@ModelAttribute BranchDTO dto, @RequestParam(name = "file") MultipartFile file)
			throws IllegalStateException, IOException {
		Branch product = branchService.save(dto, file);
		return new ResponseEntity<Branch>(product, HttpStatus.OK);
	}

	@PutMapping(value = "/{id}", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Branch> update(@ModelAttribute BranchDTO dto, @PathVariable Long id,
			@RequestParam(name = "file") MultipartFile file) throws IllegalStateException, IOException {
		Branch product = branchService.update(id, dto, file);
		if (product != null) {
			return new ResponseEntity<Branch>(product, HttpStatus.OK);
		}
		return new ResponseEntity<Branch>(HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		branchService.remove(id);

	}

}
