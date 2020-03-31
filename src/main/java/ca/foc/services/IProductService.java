package ca.foc.services;

import java.util.List;
import ca.foc.dom.ProductRegionJoin;




public interface IProductService {
	List<ProductRegionJoin>  getAllProductsInRegion(int id);
	

}
