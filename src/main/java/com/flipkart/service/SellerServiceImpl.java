package com.flipkart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.flipkart.contract.SellerLogin;
import com.flipkart.model.Seller;
import com.flipkart.repo.SellerRepo;

@Service
public class SellerServiceImpl implements ISellerService {
	@Autowired
	private SellerRepo sellerRepo;

	@Override
	public Boolean registerSeller(Seller seller) {
		seller.setIsActive(false);
		return sellerRepo.save(seller).getSellerId() != null;
	}

	@Override
	public Boolean loginSeller(SellerLogin sellerLogin) {
		Seller seller = new Seller();
		seller.setEmail(sellerLogin.getEmail());
		seller.setPassword(sellerLogin.getPassword());
		List<Seller> listSeller = sellerRepo.findAll(Example.of(seller));
		return listSeller.size() != 0;
	}

	@Override
	public Boolean isSellerExists(Seller seller) {
		Seller seller2 = new Seller();
		seller2.setEmail(seller.getEmail());

		Seller seller3 = new Seller();
		seller3.setMobileNumber(seller.getMobileNumber());

		Seller seller4 = new Seller();
		seller4.setPanNumber(seller.getPanNumber());

		Seller seller5 = new Seller();
		seller5.setGstNumber(seller.getGstNumber());

		return sellerRepo.findAll(Example.of(seller2)).size() != 0
				|| sellerRepo.findAll(Example.of(seller3)).size() != 0
				|| sellerRepo.findAll(Example.of(seller4)).size() != 0
				|| sellerRepo.findAll(Example.of(seller5)).size() != 0;
	}

	@Override
	public Boolean isSellerActive(SellerLogin sellerLogin) {
		Seller seller = new Seller();
		Boolean isActive = false;
		seller.setEmail(sellerLogin.getEmail());
		if (sellerRepo.findAll(Example.of(seller)).size() != 0) {
			isActive = sellerRepo.findAll(Example.of(seller)).get(1).getIsActive();
		}
		return isActive;
	}
}
