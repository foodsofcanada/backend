package com.capstoneproject.FoodOfCanada.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="foc_product_region")
public class ProductRegion implements Serializable{
	@Id
	@ManyToOne
	@JoinColumn
	private Product product;
	@Id
	@ManyToOne
	@JoinColumn
	private Region region;
	

}
