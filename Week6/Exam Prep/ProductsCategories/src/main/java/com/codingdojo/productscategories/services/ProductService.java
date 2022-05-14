package com.codingdojo.productscategories.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.productscategories.models.Category;
import com.codingdojo.productscategories.models.Product;
import com.codingdojo.productscategories.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepo;
	
	public Product createProduct(Product product) {
		return productRepo.save(product);
	}
	
	public List<Product> allProducts() {
		return productRepo.findAll();
	}
	
	public Product getOneProduct(Long id) {
		return productRepo.findById(id).orElse(null);
	}
	
	public List<Product> getAddedCategories(Category category){
		return productRepo.findAllByCategories(category);
	}
	
	public List<Product> getUnaddedCategories(Category category){
		return productRepo.findByCategoriesNotContains(category);
	}
	
}
