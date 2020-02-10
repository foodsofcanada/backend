package ca.foc.dao;

import java.util.List;

import ca.foc.domain.Product;


/*interface to call procedures*/
public interface ProductRepositoryInterface {
	
	public List<Product> getProductInfo(int id);
//	public List<Product> getAllProductsInRegion(int id);
	
	
}
