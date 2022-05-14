package com.codingdojo.productscategories.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.productscategories.models.Category;
import com.codingdojo.productscategories.models.Product;
import com.codingdojo.productscategories.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepo;

	public Category createCategory(Category category) {
		return categoryRepo.save(category);
	}
	
	public List<Category> allCategories() {
		return categoryRepo.findAll();
	}
	
	public Category getOneCategory(Long id) {
		return categoryRepo.findById(id).orElse(null);
	}
	
	public void addProduct(Category category, Product product) {
		List<Product> products = category.getProducts();
		products.add(product);
		categoryRepo.save(category);
	}
	
	public List<Category> getAddedProducts(Product product){
		return categoryRepo.findAllByProducts(product);
	}
	
	public List<Category> getUnaddedProducts(Product product){
		return categoryRepo.findByProductsNotContains(product);
	}

    
    
    
}
