package ca.foc.dao;

import ca.foc.domain.Pantry;
import ca.foc.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PantryRepository extends CrudRepository<Pantry, Integer> {

}