package com.flipkart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flipkart.contract.SellerLogin;
import com.flipkart.model.Seller;
import com.flipkart.service.ISellerService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/seller")
public class SellerController {
	@Autowired
	private ISellerService sellerService;

	@PostMapping("/register")
	private ResponseEntity<String> registerSeller(@RequestBody Seller seller) {
		String response = null;
		HttpStatus httpStatus = null;
		if (sellerService.isSellerExists(seller)) {
			response = "Seller Already Exists";
			httpStatus = HttpStatus.BAD_REQUEST;
		} else {
			Boolean registrationStatus = sellerService.registerSeller(seller);
			if (registrationStatus) {
				response = "Seller Registration Successfull";
				httpStatus = HttpStatus.CREATED;
			} else {
				response = "Seller Registration Failed";
				httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			}
		}
		return new ResponseEntity<String>(response, httpStatus);
	}

	@GetMapping("/login")
	private ResponseEntity<String> loginSeller(@RequestBody SellerLogin sellerLogin) {
		String response = null;
		HttpStatus httpStatus = null;
		if (sellerService.isSellerActive(sellerLogin)) {
			if (sellerService.loginSeller(sellerLogin)) {
				response = "Login Successfull";
				httpStatus = HttpStatus.OK;
			} else {
				response = "Login Failed";
				httpStatus = HttpStatus.BAD_REQUEST;
			}
		} else {
			response = "Seller is not Activated!";
			httpStatus = HttpStatus.BAD_REQUEST;
		}
		return new ResponseEntity<String>(response, httpStatus);
	}

	@GetMapping("/isSellerExists")
	private ResponseEntity<String> isSellerExists(Seller seller) {
		String response = null;
		HttpStatus httpStatus = null;
		if (sellerService.isSellerExists(seller)) {
			response = "Yes, Seller Exists!";
			httpStatus = HttpStatus.OK;
		} else {
			response = "No, Seller Doesn't Exists!";
			httpStatus = HttpStatus.BAD_REQUEST;
		}
		return new ResponseEntity<String>(response, httpStatus);
	}
}