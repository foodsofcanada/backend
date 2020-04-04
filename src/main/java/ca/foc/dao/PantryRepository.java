package ca.foc.dao;

import ca.foc.domain.Pantry;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PantryRepository extends CrudRepository<Pantry, Integer> {

	List<Pantry> findByOwner(String owner);

}