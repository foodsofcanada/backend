package ca.foc.dao;

import ca.foc.domain.Pantry;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PantryRepository extends CrudRepository<Pantry, Integer> {

	List<Pantry> findByEmail(String email);
	Optional<Pantry> findByEmailAndPantryId(String email, int PantryId);

	void deleteByEmail(String email);

}