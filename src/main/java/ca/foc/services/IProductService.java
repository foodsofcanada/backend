package ca.foc.services;

import java.util.List;

import ca.foc.dom.ProductRegionJoin;

/**
 * Interface with one method to implement in product service involving ProductRegion Table
 * @author Claudia Rivera
 *
 */
public interface IProductService {
	List<ProductRegionJoin> getAllProductsInRegion(int id, String email);
	
}
