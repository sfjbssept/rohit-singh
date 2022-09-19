package com.product.services;

import java.util.List;
import java.util.Optional;

import com.product.entities.*;

public interface IProductService {
	
	public Integer addProduct(Product product); 
	public List<Product> getAllProduct(); 
	public Optional<Product> getProduct(Integer id);
	public Product updateProduct(Integer id,Product product);
	public void deleteProduct(Integer id);
	

}