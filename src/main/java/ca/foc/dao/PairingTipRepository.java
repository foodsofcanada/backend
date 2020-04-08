package ca.foc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.foc.domain.*;
import ca.foc.dao.*;

/**
 * Interface to provide CRUD operations to PairingTips entity
 * @author Mariia Voronina
 */
	@Repository
	public interface PairingTipRepository extends JpaRepository<Product, Integer> {



}
