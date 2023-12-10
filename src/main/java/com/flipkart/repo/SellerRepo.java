package com.flipkart.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flipkart.model.Seller;

public interface SellerRepo extends JpaRepository<Seller, Integer> {

}
