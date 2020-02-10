package com.capstoneproject.FoodOfCanada.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstoneproject.FoodOfCanada.model.Product;


	@Repository
	public interface PairingTipRepository extends JpaRepository<Product, Integer> {



}
