package com.flipkart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flipkart.model.Product;
import com.flipkart.service.IProductService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private IProductService productService;

	@PostMapping("/save")
	private ResponseEntity<String> saveProduct(@RequestBody Product product) {
		String response = null;
		HttpStatus httpStatus = null;
		Boolean status = productService.saveProduct(product);
		if (status) {
			response = "Product Saved Successfully";
			httpStatus = HttpStatus.CREATED;
		} else {
			response = "Inable to Save Product";
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<String>(response, httpStatus);
	}
}
