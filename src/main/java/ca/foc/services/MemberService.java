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
		
		Member memberDb = null;
		Optional<Member> member= memberRepository.findByEmail(email);  // find a member within the database by the email. Email is unique 
		if (member.isPresent()) {
			memberDb= member.get();		
			if (memberDb.getEmail().equals(email)||memberDb.getPassword().equals(password)) {
				
			}
		}
		else
		{
			System.out.println("member doesnt exist");
		}
		
			
		return memberDb;
	}
	
	/*Register a new member
	 * Return true if member was added
	 * */
	
	public boolean NewMember(Member member) {
		boolean result= false;
		
		Optional<Member> m = memberRepository.findByEmail(member.getEmail());
		
		if (!m.isPresent()) {
			result=true;  
			memberRepository.save(member);
		}
		else
			result=false;
		
		return result;
		
	}
	



	
	
}

