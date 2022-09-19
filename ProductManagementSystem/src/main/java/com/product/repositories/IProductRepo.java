package com.product.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.entities.Product;

public interface IProductRepo extends JpaRepository<Product, Integer> {

}
