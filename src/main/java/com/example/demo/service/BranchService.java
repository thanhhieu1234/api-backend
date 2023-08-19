package com.example.demo.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.converter.BranchConverter;
import com.example.demo.dto.BranchDTO;
import com.example.demo.dto.CategoryDTO;
import com.example.demo.entity.Branch;
import com.example.demo.repository.IBranchRepository;

@Service
public class BranchService {

	@Autowired
	private IBranchRepository branchRepository;

	@Autowired
	private BranchConverter branchConverter;

	@Autowired
	private ServletContext context;

	public Branch save(BranchDTO dto, MultipartFile multipartFile) throws IllegalStateException, IOException {

		String name = this.uploadImage(multipartFile);
		Branch branch = branchConverter.toEntity(dto);
		branch.setLogo(name);
		branch.setCreatedDate(new Date());
		String folder = "";
		Path path = this.getPath(folder, name);
		multipartFile.transferTo(path);
		return branchRepository.save(branch);
		
	}

	public Path getPath(String folder, String name) {
		File f = Paths.get(context.getRealPath("files"), folder).toFile();
		if (!f.exists()) {
			f.mkdirs();
		}
		return Paths.get(f.getAbsolutePath(), name);
	}

	private String uploadImage(MultipartFile multipartFile) {
		String file = multipartFile.getOriginalFilename();
		String name = file.hashCode() + file.substring(file.lastIndexOf("."));
		return name;
	}

	public Branch update(Long id, BranchDTO dto, MultipartFile file) throws IllegalStateException, IOException {
		Branch branch = this.findOneByID(id);
		if (branch != null) {
			String name = this.uploadImage(file);
			branch.setName(dto.getName());
			branch.setNameCode(dto.getName());
			branch.setStatus(dto.getStatus());
			branch.setModifiedDate(new Date());
			branch.setLogo(name);
			String folder = "";
			Path path = this.getPath(folder, name);
			file.transferTo(path);
			return branchRepository.save(branch);
		}
		return null;
	}

	public List<Branch> findAll() {
		return branchRepository.findAll();
	}

	public Branch findOneByID(Long id) {
		return branchRepository.findById(id).orElse(null);
	}

	public void remove(Long id) {
		Branch categoryProduct = this.findOneByID(id);
		branchRepository.delete(categoryProduct);
	}

}
