package ca.foc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import ca.foc.domain.Product;

public class ProductImplementsRepository implements ProductRepositoryInterface {
	@PersistenceContext
	private EntityManager em;

	public List<Product> getProductInfo(int id) {
        StoredProcedureQuery productInfo =
                em.createNamedStoredProcedureQuery("getProductInfo");
        return productInfo.getResultList();
    }

	public List<Product> getAllProductsInRegion(int id) {
        StoredProcedureQuery productsInRegion =
                em.createNamedStoredProcedureQuery("getProductInfo");
        return productsInRegion.getResultList();
    }
}
