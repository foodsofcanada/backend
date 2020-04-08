package ca.foc.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ca.foc.domain.TopTenSearched;
import ca.foc.domain.TopTenSearchedIdentity;

/**
 * Interface to provide CRUD operations to TopTenSearched entity
 * @author Claudia Rivera
 *
 */
@Repository
public interface TopTenSearchedRepository extends CrudRepository<TopTenSearched, TopTenSearchedIdentity> {


}
