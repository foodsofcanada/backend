package ca.foc.services;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.foc.dao.MemberRepository;
import ca.foc.domain.Member;

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
	
	public boolean CheckMember(String email, String password) {
		boolean result = false; 
//		EntityManager em = emf.createEntityManager();
//		Query query = em.createQuery("Select" + " count(email) from Member m " + " where m.email =" + email
//				+ " and m.password = " + password);
//
//		long counter = (long) query.getSingleResult();
//		if (counter == 1)
//			result = true;
//		if (counter == 0)
//			result=false;
		Optional<Member> member= memberRepository.findByEmail(email);  // find a member within the database by the email. Email is unique 
		if (member.isPresent()) {
			Member memberDb= member.get();		
			if (memberDb.getEmail().equals(email)||memberDb.getPassword().equals(password)) {
				result = true;  //
			}
		}
		else
		{
			System.out.println("member doesnt exist");
			result = false; //that member doesn't exist in the database
		}
		
			
		return result;
	}



	
	
}

