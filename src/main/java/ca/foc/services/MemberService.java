package ca.foc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.foc.dao.MemberRepository;
import ca.foc.domain.Member;

@Service
public class MemberService {

	@Autowired
	MemberRepository memberRepository;
	
	public Iterable<Member> getAllMembers(){
		return memberRepository.findAll();
	}

	//@Override
	public void saveMember(Member member) {
		memberRepository.save(member);
		
	}
	
	public Member findByEmail(String email){
		return memberRepository.findByEmail(email);
	}


	
	
}

