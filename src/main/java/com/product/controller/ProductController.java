package com.product.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public Optional<Product>  getProduct(@PathVariable Integer id){
		return productService.getProduct(id);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<Product> upateProduct(@PathVariable Integer id,@RequestBody Product product){
		return new ResponseEntity<Product>(productService.updateProduct(id,product),HttpStatus.OK);
	}
	@DeleteMapping("del/{id}")
	public ResponseEntity<Product> deleteProduct(@PathVariable Integer id){
		System.out.println(id);
		ResponseEntity<Product> responseEntity = new ResponseEntity<Product>(HttpStatus.OK);
		try {
			productService.deleteProduct(id);
		}catch(Exception e) {
			responseEntity = new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
		return responseEntity;
		
	}
}