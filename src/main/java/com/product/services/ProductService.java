package com.product.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.entities.*;
import com.product.repositories.*;

@Service
public class ProductService implements IProductService {
	
	@Autowired
	IProductRepo productRepository;

	@Override
	public Integer addProduct(Product product) {
		Product savedProduct = productRepository.save(product);
		return savedProduct.getId();
	}

}