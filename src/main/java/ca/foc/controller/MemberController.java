package ca.foc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.foc.domain.Member;
import ca.foc.services.MemberService;
import ca.foc.services.validator.MemberValidator;

@Controller
public class MemberController {

	@Autowired
	MemberService memberService;
	
	@Autowired
	private MemberValidator memberValidator;

	@GetMapping("/")
	public String getMemberForm(Model model) {
		return "This is Home page";
	}

	

	@GetMapping("/registration")
	public String registration(Model model) {
		model.addAttribute("memberForm", new Member());

		return "registration";
	}

	@PostMapping("/registration")
	public String registration(@ModelAttribute("memberForm") Member memberForm, BindingResult bindingResult) {
		memberValidator.validate(memberForm, bindingResult);

		if (bindingResult.hasErrors()) {
			return "registration";
		}
		memberService.saveMember(memberForm);

		// securityService.autoLogin(userForm.getUsername(),
		// userForm.getPasswordConfirm());

		return "redirect:/welcome";
	}
	@GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }
	
	
	@GetMapping("/save-member")
//	@PostMapping({"/save-member"})
//	public Member addMember(@RequestBody Member member) {
//	memberService.saveMember(member);
	public String saveMember(@RequestParam String email, @RequestParam String password, @RequestParam String firstname, @RequestParam String lastname, @RequestParam int role) {
		Member member = new Member(email, password, firstname, lastname, role);
		memberService.saveMember(member);
		return "Member saved";
		// return member;
	}

}
