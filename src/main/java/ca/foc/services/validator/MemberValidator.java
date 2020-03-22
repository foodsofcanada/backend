package ca.foc.services.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ca.foc.domain.Member;
import ca.foc.services.MemberService;


@Component
public class MemberValidator implements Validator {
	
	
		@Autowired
		private MemberService memberService;
		
		@Override
		public boolean supports(Class aClass) {
			return Member.class.equals(aClass);
		}
		@Override
		public void validate(Object o, Errors errors) {
			Member member = (Member) o;
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");
			if (member.getEmail().length() < 6 || member.getEmail().length() > 32) {
				errors.rejectValue("email", "Size.userForm.email");
			}
			if (memberService.findByEmail(member.getEmail()) != null) {
				errors.rejectValue("username", "Duplicate.memberForm.member");
			}
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
			if (member.getPassword().length() < 8 || member.getPassword().length() > 32) {
				errors.rejectValue("password", "Size.memberForm.password");
			}
			
		}
	}

	


