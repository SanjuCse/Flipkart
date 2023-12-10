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
public class Seller {
	@Id
	@SequenceGenerator(name = "sellerIdGen", sequenceName = "sellerIdGen", initialValue = 1001, allocationSize = 1)
	@GeneratedValue(generator = "sellerIdGen", strategy = GenerationType.SEQUENCE)
	private Integer sellerId;

	@Nonnull
	private String email;

	@Nonnull
	private String panNumber;

	@Nonnull
	private String gstNumber;

//	private Blob signature;

	@Nonnull
	private Integer pinCode;

	@Nonnull
	private String Address;

//	private Blob addressProof;

	@Nonnull
	private String password;

	@Nonnull
	private Long mobileNumber;

	private Boolean isActive;

	@CreationTimestamp
	private LocalDate createdDate;

	@UpdateTimestamp
	private LocalDate updatedDate;
}