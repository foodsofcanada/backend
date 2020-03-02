package ca.foc.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ca.foc.domain.Member;

@Repository
public interface MemberRepository extends CrudRepository<Member, String>{

		public Member findByEmail(String email);
//		
//		public Optional<Member> findByEmailAndHashedpw(String email, String hashedpw);
//        
//		public void saveMember(Member member);
	
}
