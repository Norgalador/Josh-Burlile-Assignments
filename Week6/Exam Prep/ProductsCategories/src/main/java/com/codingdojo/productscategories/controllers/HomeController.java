package com.codingdojo.productscategories.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.productscategories.models.Category;
import com.codingdojo.productscategories.models.Product;
import com.codingdojo.productscategories.services.CategoryService;
import com.codingdojo.productscategories.services.ProductService;

@Controller
public class HomeController {

	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
	
	//	Root route
	@GetMapping("/")
	public String index(Model productModel, Model categoryModel) {
		productModel.addAttribute("products", productService.allProducts());
		categoryModel.addAttribute("categories", categoryService.allCategories());
	return "index.jsp";
  }
	
	//	Create a new Product
	@GetMapping("/new/product")
	public String newProduct(@ModelAttribute("newProduct") Product product) {
		return "newProduct.jsp";
	}
	
	//	Post new product
	@PostMapping("/product/create")
	public String postProduct(@Valid @ModelAttribute("newProduct") Product product,
			BindingResult result) {
		if(result.hasErrors()) {
 			return "newProduct.jsp";
 		}
 		else {
 			productService.createProduct(product);
 			return "redirect:/";
 		}
	}
	
	
	//	Create a new Category
	@GetMapping("/new/category")
	public String newCategory(@ModelAttribute("category") Category category) {
		return "newCategory.jsp";
	}
	
	//	Post new category
	@PostMapping("/category/create")
	public String postCategory(@Valid @ModelAttribute("category") Category category,
			BindingResult result) {
		if(result.hasErrors()) {
 			return "newCategory.jsp";
 		}
 		else {
 			categoryService.createCategory(category);
 			return "redirect:/";
 		}
	}
	
	//	Show a product
	@GetMapping("/product/productDetails/{id}")
	public String showProduct(@PathVariable Long id, Model productModel) {
		Product myProduct=productService.getOneProduct(id);
		productModel.addAttribute("product", myProduct);
		return "showProduct.jsp";
	}
	
	//	Show a category
	@GetMapping("/category/categoryDetails/{id}")
	public String showCategory(@PathVariable Long id, Model categoryModel) {
		Category category=categoryService.getOneCategory(id);
		categoryModel.addAttribute("addedProducts", productService.getAddedCategories(category));
		categoryModel.addAttribute("unaddedProducts", productService.getUnaddedCategories(category));
		categoryModel.addAttribute("category", categoryService.getOneCategory(id));
		return "showCategory.jsp";
	}
	
	//	Add product to category
	@GetMapping("/category/{id}/addProduct")
	public String addProductToCategory(@PathVariable Long id) {
		Product product=productService.getOneProduct(id);
		Category category=categoryService.getOneCategory(id);
		categoryService.addProduct(category, product);
		return "redirect:/category/categoryDetails/{id}";
	}
	
}
