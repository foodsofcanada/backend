package ca.foc.services;

import ca.foc.dao.ProductRepository;
import ca.foc.dom.ProductDetail;
import ca.foc.dom.ProductRegionJoin;
import ca.foc.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 * ProductServices - ca.foc.services.ProductServices
 * 
 * This class implements methods for Product entity and ProductRegion
 * 
 */
@Service
public class ProductService implements IProductService {

	@Autowired
	ProductRepository productRepository;
	@Autowired
	EntityManagerFactory emf;

	/* Returns all products in the database */
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	/* Returns an optional object */
	public Optional<Product> getProductInfo(int id) {
		return productRepository.findById(id);
	}

	/* Add a new product in the database */
	public Product addProduct(Product product) {
		productRepository.save(product);
		return product;
	}

	/* Delete a product in the database */
	public void deleteProduct(int id) {
		productRepository.deleteById(id);
	}

	/* Returns a list of products in a Region */
	@Override
	public List<ProductRegionJoin> getAllProductsInRegion(int id) {

		List<ProductRegionJoin> resultSearch = null;
		List<ProductRegionJoin> list = new ArrayList<ProductRegionJoin>();
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT pr.coordinate, pr.reg_id, p.prod_id, p.name from Product p "
				+ "INNER JOIN ProductRegion pr ON p.prod_id=pr.prod_id "
				+ "WHERE pr.reg_id =" + id);
		
		resultSearch = query.getResultList();
		//List<ProductDetail> list = (List<ProductDetail>) query.getResultList();
		//em.close();
		
		Iterator it = resultSearch.iterator();
		while (it.hasNext()) {
			Object[] line = (Object[]) it.next();
			ProductRegionJoin prj = new ProductRegionJoin();
			prj.setCoordinates((String) line[0]);
			prj.setReg_id((int) line[1]);
			prj.setProd_id((int) line[2]);
			prj.setName((String) line[3]);
			list.add(prj);
		}
		em.close();

		return list;
	}
	
	

}
