package ca.foc.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ca.foc.domain.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>, ProductRepositoryInterface {
	

}