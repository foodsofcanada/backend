package ca.foc.dao;

import org.springframework.data.repository.CrudRepository;

import ca.foc.domain.Product;
import ca.foc.domain.ProductSuggestion;

public interface ProductSuggestionRepository  extends CrudRepository<ProductSuggestion, Integer>{

}
