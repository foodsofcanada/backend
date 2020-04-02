package ca.foc.services;

import ca.foc.dao.FavProductsRepository;
import ca.foc.dao.ProductRepository;
import ca.foc.dom.ProductDetail;
import ca.foc.dom.ProductRegionJoin;
import ca.foc.domain.FavouriteProductsIdentity;
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
	FavProductsRepository favProductsRepository;
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
	public List<ProductRegionJoin> getAllProductsInRegion(int id, String email) {
		String memberId=email;
		List<ProductRegionJoin> resultSearch = null;
		List<ProductRegionJoin> list = new ArrayList<ProductRegionJoin>();
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT pr.coordinate, pr.regionId, p.productId, p.name from Product p "
				+ "INNER JOIN ProductRegion pr ON p.productId=pr.productId "
				+ "WHERE pr.regionId =" + id);
		
		resultSearch = query.getResultList();
		
		Iterator it = resultSearch.iterator();
		while (it.hasNext()) {
			Object[] line = (Object[]) it.next();
			ProductRegionJoin prj = new ProductRegionJoin();
			prj.setCoordinates((String) line[0]);
			prj.setRegionId((int) line[1]);
			prj.setProductId((int) line[2]);
			prj.setName((String) line[3]);
			list.add(prj);
		}
	       if (!memberId.isEmpty()) {
			 FavouriteProductsIdentity key= new FavouriteProductsIdentity();
			 key.setEmail(memberId);
			
			for(int i=0; i<list.size();i++) {
				
				 key.setProductId(list.get(i).getProductId());
				 key.setRegionId(list.get(i).getRegionId());
				 if(favProductsRepository.existsById(key)) {
					 list.get(i).setIsFavourite(true);
				 }
							 
			}						
			
		}
		
		
		em.close();

		return list;
	}
	
	

}
