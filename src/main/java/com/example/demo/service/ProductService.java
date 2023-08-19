package com.example.demo.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.converter.ProductConverter;
import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Branch;
import com.example.demo.entity.CategoryProduct;
import com.example.demo.entity.Image;
import com.example.demo.entity.Product;
import com.example.demo.repository.IBranchRepository;
import com.example.demo.repository.ICategoryRepository;
import com.example.demo.repository.IProductRepository;

@Service
public class ProductService {

	@Autowired
	private IProductRepository iProductRepository;

	@Autowired
	private IBranchRepository ibranchRepository;

	@Autowired
	private ICategoryRepository icategoryRepository;

	@Autowired
	private ProductConverter productConverter;

	@Autowired
	private ServletContext context;

	public List<Product> findAll() {
		return iProductRepository.findAll();
	}

	public Product save(ProductDTO dto, MultipartFile multipartFile, MultipartFile[] files) throws Exception {
		Branch branch = ibranchRepository.loadBranchByID(dto.getBranch());
		CategoryProduct categoryProduct = icategoryRepository.loadCategoryByID(dto.getCategoryProduct());

		if (branch == null) {
			throw new Exception();
		}
		if (categoryProduct == null) {
			throw new Exception();
		}
		List<Image> images = this.uploadImages(files);
		String name = this.uploadImage(multipartFile);
		Product product = productConverter.toEntity(dto);
		product.setImage(name);
		product.setBranch(branch);
		product.setCategoryProduct(categoryProduct);
		product.setImages(images);
		product = iProductRepository.save(product);
		if (product != null) {
			return product;
		}
		return null;
	}

	public Product update(Long id, ProductDTO dto, MultipartFile multipartFile, MultipartFile[] files)
			throws Exception {

		Product product = this.findOneByID(id);
		if (product == null) {
			return null;
		}

		Branch branch = ibranchRepository.loadBranchByID(dto.getBranch());
		CategoryProduct categoryProduct = icategoryRepository.loadCategoryByID(dto.getCategoryProduct());

		if (branch == null) {
			throw new Exception();
		}
		if (categoryProduct == null) {
			throw new Exception();
		}
		List<Image> images = this.uploadImages(files);
		String name = this.uploadImage(multipartFile);
		product.setTitle(dto.getTitle());
		product.setDescription(dto.getDescription());
		product.setDetails(dto.getDetails());
		product.setPrice(dto.getPrice());
		product.setViewCount(dto.getViewCount());
		product.setHot(dto.getHot());
		product.setStatus(dto.getStatus());
		product.setImage(name);
		product.setBranch(branch);
		product.setCategoryProduct(categoryProduct);
		product.setImages(images);
		product = iProductRepository.save(product);
		return product;
	}

	private String uploadImage(MultipartFile multipartFile) throws IllegalStateException, IOException {
		if (multipartFile.isEmpty()) {
			System.out.println("vo");
			return "noImg.png";
		}
		String file = multipartFile.getOriginalFilename();
		String name = file.hashCode() + file.substring(file.lastIndexOf("."));
		String folder = "";
		Path path = this.getPath(folder, name);
		multipartFile.transferTo(path);
		return name;
	}

	private List<Image> uploadImages(MultipartFile[] multipartFile) throws IllegalStateException, IOException {
		List<Image> images = new ArrayList<>();
		for (MultipartFile image : multipartFile) {
			String name = this.uploadImage(image);
			Image image2 = new Image();
			image2.setImage(name);
			images.add(image2);
			String folder = "";
			Path path = this.getPath(folder, name);
			image.transferTo(path);
		}
		return images;
	}

	private Path getPath(String folder, String name) {
		File f = Paths.get(context.getRealPath("files"), folder).toFile();
		if (!f.exists()) {
			f.mkdirs();
		}
		return Paths.get(f.getAbsolutePath(), name);
	}

	public Product findOneByID(Long id) {
		return iProductRepository.findById(id).orElse(null);
	}
}
