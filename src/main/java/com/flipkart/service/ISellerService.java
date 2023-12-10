package com.flipkart.service;

import com.flipkart.contract.SellerLogin;
import com.flipkart.model.Seller;

public interface ISellerService {
	Boolean registerSeller(Seller seller);

	Boolean loginSeller(SellerLogin sellerLogin);

	Boolean isSellerExists(Seller seller);

	Boolean isSellerActive(SellerLogin sellerLogin);
}
