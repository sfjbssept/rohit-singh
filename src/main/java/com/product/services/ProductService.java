package com.product.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.entities.*;
import com.product.exception.ResourceNotFoundException;
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
	public Optional<Product> getProduct(Integer Id) {
		return productRepository.findById(Id);
	}

	@Override
	public Product updateProduct(Integer id,Product product) {

		//we will check the product with id exists or not
		Product existingProduct = productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
		
		existingProduct.setProductName(product.getProductName());
		existingProduct.setProductBrand(product.getProductBrand());
		existingProduct.setProductPrice(product.getProductPrice());
		
		//setting the updated value and save it to repo.
		productRepository.save(existingProduct);
		return existingProduct;
	}

	@Override
	public void deleteProduct(Integer id) {
		// TODO Auto-generated method stub
		Product existingProduct = productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
		productRepository.delete(existingProduct);
	}

}