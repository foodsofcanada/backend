package ca.foc.dao;

<<<<<<< Updated upstream
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ca.foc.domain.Product;
=======
import ca.foc.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
>>>>>>> Stashed changes

/**
 * ProductRepository - ca.foc.dao.ProductRepository
 */
@Repository
<<<<<<< Updated upstream
public interface ProductRepository extends CrudRepository<Product, Long>, ProductRepositoryInterface {
	

}
=======
public interface ProductRepository extends JpaRepository<Product, Integer> {


}
>>>>>>> Stashed changes
