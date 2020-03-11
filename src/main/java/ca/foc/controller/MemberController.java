package ca.foc.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import ca.foc.dao.MemberRepository;
import ca.foc.domain.Member;
import ca.foc.services.MemberService;

@RequestMapping(path = "/member")
@Controller
public class MemberController {

	private MemberRepository memberRepository;


//	@PostMapping("/register")
//	public void register(@RequestBody Member member) {
//		member.setPassword();
//	}

	//	@GetMapping("/save-member")
//	@PostMapping({"/register"})
//	@ResponseBody
//	public Member addMember(@RequestBody Member member) {
//		memberService.saveMember(member);
//		return member;
//	}
//	public String saveMember(@RequestParam String email, @RequestParam String password, @RequestParam String firstname, @RequestParam String lastname, @RequestParam int role) {
//		Member member = new Member(email, password, firstname, lastname, role);
//		memberService.saveMember(member);
////		return "Member saved";
//}

//	/*Find a member by email*/
//	@GetMapping("/members/{email}")
//	@ResponseBody
//	public Optional<Member> findMember(@PathVariable String email) {
//
//	 return memberService.findByEmail(email);
//	}
	
	/*Verify if a member exists in the database. Return true if exists, false other wise*/
//	@PostMapping ("/test")
//	@ResponseBody
//	 public boolean  checkMember(@RequestBody Member member) {
//	    boolean check = memberService.CheckMember(member.getEmail(),member.getPassword());
//
//	    if (!check )
//	    System.out.println(" False " );
//	    else
//		System.out.println(" True" );
//
//		return  check;
//	}
	
	

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
