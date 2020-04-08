package ca.foc.dao;

import ca.foc.domain.Region;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface to provide CRUD operations to Region entity
 * @author Mariia Voronina
 *
 */
@Repository
public interface RegionRepository extends CrudRepository<Region, Integer> {
	@Override
	public List<Region> findAll();
	
}

