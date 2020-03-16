package ca.foc.services;

import ca.foc.dao.ProductRepository;
import ca.foc.dom.ProductDetail;
import ca.foc.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 * ProductServices - ca.foc.services.ProductServices
 * 
 * This class implements methods for Product entity:
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
	public List<ProductDetail> getAllProductsInRegion(int id) {

		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("Select" + " p from Product p "
				+ "inner join ProductRegion pr on p.prod_id=pr.prod_id where pr.reg_id =" + id);
		@SuppressWarnings("unchecked")
		List<ProductDetail> list = (List<ProductDetail>) query.getResultList();
		em.close();

		return list;
	}
	
	

}
