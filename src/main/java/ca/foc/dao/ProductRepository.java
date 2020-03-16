package ca.foc.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ca.foc.domain.*;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
	@Override
	public List<Product> findAll();

}