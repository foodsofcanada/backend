package ca.foc.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ca.foc.domain.PantryProductRegion;

/**
 * Interface to provide CRUD operations to PantryProductRegion entity
 * @author Claudia Rivera, Maria Voronina
 *
 */
@Repository
public interface PantryProductRegionRepository extends CrudRepository<PantryProductRegion, Integer>{
	public  Optional<PantryProductRegion> findByPantryIdAndProductIdAndRegionId(int pantryId, int productId, int regionId);
	public  Optional<PantryProductRegion> deleteByPantryIdAndProductIdAndRegionId(int pantryId, int productId, int regionId);
	public void deleteByPantryId(int pantryId);
}
