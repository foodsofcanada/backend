package ca.foc.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ca.foc.dom.FavouriteResponse;
import ca.foc.domain.Member;

/**
 * Interface to provide CRUD operations to Member entity
 * @author Claudia Rivera, Mariia Voronina
 *
 */
@Repository
public interface MemberRepository extends CrudRepository<Member, String> {

		public  Optional<Member> findByEmail(String email);

		public void deleteByEmail(String email);

	
	
}
