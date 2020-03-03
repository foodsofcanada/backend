package ca.foc.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import ca.foc.domain.*;


@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
	 @Override
	    public List<Product> findAll();
	
}