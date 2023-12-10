package com.flipkart.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flipkart.model.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}
