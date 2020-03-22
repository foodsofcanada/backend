package ca.foc.services;

import java.util.List;
import java.util.Optional;

import ca.foc.dom.ProductDetail;
import ca.foc.dom.ProductRegionJoin;
import ca.foc.domain.Product;



public interface IProductService {
	//List<ProductDetail> JPQLQuery(int reg);
	//List<Product>  getProductInfo(int id);
	List<ProductRegionJoin>  getAllProductsInRegion(int id);

}
