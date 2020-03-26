package ca.foc.services;

import java.util.List;
import ca.foc.dom.ProductRegionJoin;




public interface IProductService {
	//List<ProductDetail> JPQLQuery(int reg);
	//List<Product>  getProductInfo(int id);
	List<ProductRegionJoin>  getAllProductsInRegion(int id);
	

}
