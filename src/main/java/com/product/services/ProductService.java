package com.product.services;

import java.util.List;
import java.util.Optional;

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

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Optional<Product> getProduct(Integer id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id);
	}

}