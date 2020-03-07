package ca.foc.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;

import ca.foc.dao.MemberRepository;
import ca.foc.domain.Member;
import ca.foc.services.MemberService;

@Controller
public class MemberController {

	@Autowired
	MemberService memberService;
	
	
	
//	@GetMapping("/save-member")
	@PostMapping({"/save-member"})
	@ResponseBody
	public Member addMember(@RequestBody Member member) {
	memberService.saveMember(member);
	return member;

	
	}
	/*Find a member by email*/
	@GetMapping("/members/{email}")
	@ResponseBody
	public Optional<Member> findMember(@PathVariable String email) {
        
	 return memberService.findByEmail(email);
	}
	
	/*Verify if a member exists in the database. Return true if exists, false other wise*/
	@PostMapping ("/login")
	@ResponseBody
	 public Member  checkMember(@RequestBody Member member) {
	    Member check = memberService.CheckMember(member.getEmail(),member.getPassword());
		return  check;
	}
	
	

//	@PostMapping("/registration")
//	public String registration(@ModelAttribute("memberForm") Member memberForm, BindingResult bindingResult) {
//		memberValidator.validate(memberForm, bindingResult);
//
//		if (bindingResult.hasErrors()) {
//			return "registration";
//		}
//		memberService.saveMember(memberForm);
//
//		// securityService.autoLogin(userForm.getUsername(),
//		// userForm.getPasswordConfirm());
//
//		return "redirect:/welcome";
//	}

}
