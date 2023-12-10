package com.flipkart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flipkart.model.Product;
import com.flipkart.repo.ProductRepo;

@Service
public class ProductServiceImpl implements IProductService {
	@Autowired
	private ProductRepo productRepo;

	@Override
	public Boolean saveProduct(Product product) {
		return productRepo.save(product).getProductId() != null;
	}
}
