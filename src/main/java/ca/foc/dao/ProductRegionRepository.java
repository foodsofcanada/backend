package ca.foc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.foc.domain.ProductRegion;
/**
 * Interface to provide CRUD operations to ProductRegion entity
 * @author Claudia Rivera
 *
 */
@Repository
public interface ProductRegionRepository extends JpaRepository<ProductRegion, Integer>{

}
