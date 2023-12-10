package com.flipkart.model;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Product {
	@Id
	@SequenceGenerator(name = "productIdGen", sequenceName = "productIdGen", initialValue = 2001, allocationSize = 1)
	@GeneratedValue(generator = "productIdGen", strategy = GenerationType.SEQUENCE)
	private Integer productId;

	@Nonnull
	private String productName;

	@Nonnull
	private String brandName;

	@Nonnull
	private String Category;

	@Nonnull
	private String subCategory;

	@Nonnull
	private String productType;

	@Nonnull
	private Double price;

	@Nonnull
	private String productImageUrl;

	@CreationTimestamp
	private LocalDate createdDate;

	@UpdateTimestamp
	private LocalDate updatedDate;
}
