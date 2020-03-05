package ca.foc.services;

import java.util.List;
import java.util.Optional;

import ca.foc.dom.ProductDetail;
import ca.foc.domain.Product;



public interface IQueryService {
	//List<ProductDetail> JPQLQuery(int reg);
	
	List<ProductDetail>  getAllProductsInRegion(int id);
	List<Product>  getProductInfo(int id);

}
