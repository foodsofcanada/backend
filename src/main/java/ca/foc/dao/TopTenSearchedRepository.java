package ca.foc.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ca.foc.domain.TopTenSearched;
import ca.foc.domain.TopTenSearchedIdentity;

@Repository
public interface TopTenSearchedRepository extends CrudRepository<TopTenSearched, TopTenSearchedIdentity> {

	//List<TopTenSearched> findByProductidOrderBySearch_counterDesc();


}
