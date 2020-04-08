package ca.foc.dao;

import java.util.Iterator;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ca.foc.dom.ProductDetail;
import ca.foc.domain.*;

/**
 * Interface to provide CRUD operations to Product entity
 * @author 787428
 *
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
	@Override
	public List<Product> findAll();
	

}