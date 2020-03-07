package ca.foc.services;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.foc.dao.MemberRepository;
import ca.foc.domain.Member;

/**
 * Service class for Member: 
 * @author 787428
 *
 */

@Service
public class MemberService {

	@Autowired
	MemberRepository memberRepository;
	@Autowired
	EntityManagerFactory emf;
	
	public Iterable<Member> getAllMembers(){
		return memberRepository.findAll();
	}

	//@Override
	public void saveMember(Member member) {
		memberRepository.save(member);
		
	}
	
	public Optional<Member> findByEmail(String email){
		return memberRepository.findByEmail(email);
	}
	
	/*Validate email and password*/
	public Member CheckMember(String email, String password) {
		boolean result = false; 
		Member memberDb = null;
		Optional<Member> member= memberRepository.findByEmail(email);  // find a member within the database by the email. Email is unique 
		if (member.isPresent()) {
			memberDb= member.get();		
			if (memberDb.getEmail().equals(email)||memberDb.getPassword().equals(password)) {
				result = true;  //
			}
		}
		else
		{
			System.out.println("member doesnt exist");
			result = false; //that member doesn't exist in the database
		}
		
			
		return memberDb;
	}



	
	
}

