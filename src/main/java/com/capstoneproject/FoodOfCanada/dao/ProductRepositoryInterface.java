package com.capstoneproject.FoodOfCanada.dao;

import java.util.List;

import com.capstoneproject.FoodOfCanada.model.Product;


/*interface to call procedures*/
public interface ProductRepositoryInterface {
	
	public List<Product> getProductInfo(int id);
	public List<Product> getAllProductsInRegion(int id);
	
	
}
