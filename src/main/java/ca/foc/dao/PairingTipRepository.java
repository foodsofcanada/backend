package ca.foc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.foc.domain.*;
import ca.foc.dao.*;

	@Repository
	public interface PairingTipRepository extends JpaRepository<Product, Integer> {



}
