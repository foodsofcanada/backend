package ca.foc.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.bind.annotation.RequestBody;

import ca.foc.dao.MemberRepository;
import ca.foc.domain.Member;
import ca.foc.services.MemberService;
/**
 * Member Controller
 * 
 * @author
 *
 *Implemented:
 *           Register(Create an account)
 *           Login
 *           Find members by Id (not in controller class)
 *           Claudia. March/09/2020
 *
 *Missing: 
 * ---Edit profile 
 * ---Delete profile
 * ---Hash password
 * ---add products To Favorites
 * ---delete from favourites
 * ---getProducts in Favourites
 * ---Suggest a product
 * ---Change member role
 * ---View suggestions
 * 
 * Claudia: March/15/2020
 * 
 */
@Controller
public class MemberController {

	@Autowired
	MemberService memberService;
	

	/*Find a member by email*/
	@GetMapping("/members/{email}")
	@ResponseBody
	public Optional<Member> findMember(@PathVariable String email) {
        
	 return memberService.findByEmail(email);
	}
	
	/*Verify if a member exists in the database. Return the member founded, null otherwise*/
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping ("/login")
	@ResponseBody
	 public Member  checkMember(@RequestBody Member member) {
	    Member check = memberService.CheckMember(member.getEmail(),member.getPassword());
		return  check;
	}
	
	/*Register a new member. Returns true if the member was added. false other wise*/
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/registration")
	@ResponseBody
	public boolean  addMember(@RequestBody Member member) {
		
		return memberService.NewMember(member);
	}
	
	



}
