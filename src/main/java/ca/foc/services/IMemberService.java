package ca.foc.services;

import ca.foc.domain.Member;

/*Interface Member service*/
public  interface IMemberService {

	public Iterable<Member> getAllMembers();
	public void saveMember(Member member);	
	
}