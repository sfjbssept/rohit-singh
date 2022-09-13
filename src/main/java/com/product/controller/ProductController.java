package com.product.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.entities.Product;
import com.product.services.IProductService;

@RestController
public class ProductController {

	@Autowired
	IProductService productService;
	
	@PostMapping("/addproduct")
	public Integer saveProduct(@RequestBody Product product) {
		Integer id = productService.addProduct(product);
		System.out.println(id);
		return id;
	}
	@GetMapping("/allproducts")
	public List<Product> getAllProducts(){
		return productService.getAllProduct();
	}
	@GetMapping("/product/{id}")
	public Optional<Product> getProduct(@PathVariable Integer id){
		return productService.getProduct(id);
	}
}