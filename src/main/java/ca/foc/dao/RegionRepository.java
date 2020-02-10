package ca.foc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.foc.domain.Region;

public interface RegionRepository extends JpaRepository<Region,Integer>
{

}
