package com.capstoneproject.FoodOfCanada.model;

import javax.persistence.*;

@Entity
@Table(name="foc_products_pairing")
public class PairingTip {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId; // primary key table products_pairing

	@ManyToOne
	@JoinColumn
	private Product product;

}
