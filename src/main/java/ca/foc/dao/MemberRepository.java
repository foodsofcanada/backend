package ca.foc.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ca.foc.domain.Member;

@Repository
public interface MemberRepository extends CrudRepository<Member, String> {

		public  Optional<Member> findByEmail(String email);

		public void deleteByEmail(String email);

	
	
}
