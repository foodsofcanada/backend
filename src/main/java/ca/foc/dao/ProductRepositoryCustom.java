package ca.foc.dao;

import java.util.List;

import ca.foc.domain.Product;


/*interface to call procedures*/
public interface ProductRepositoryCustom {
	
    public List<String> getAllProductsInRegion(int id);
	
	
}
