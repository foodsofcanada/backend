package ca.foc.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ca.foc.domain.TopTenSearched;

@Repository
public interface TopTenSearchedRepository extends CrudRepository<TopTenSearched, Integer> {

	//List<TopTenSearched> findByProductidOrderBySearch_counterDesc();


}
