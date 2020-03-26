package ca.foc.dao;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import ca.foc.domain.ProductRegion;

public interface ProductRegionRepository extends JpaRepository<ProductRegion, Integer>{
	public  Optional<ProductRegion> findByProdId(int prodId);

}
