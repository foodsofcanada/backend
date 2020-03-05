package ca.foc.controller;

import ca.foc.dao.MemberRepository;
import ca.foc.domain.Member;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * MemberController - ca.foc.controller.MemberController
 */
@RestController
@RequestMapping("/member")
public class MemberController {

    private MemberRepository repository;
    private BCryptPasswordEncoder bcrypt;

    public MemberController(MemberRepository repository, BCryptPasswordEncoder bcrypt) {
        this.repository = repository;
        this.bcrypt = bcrypt;
    }

    @PostMapping("/signup")
    public void SignUp(@RequestBody Member member) {
        member.setPassw(bcrypt.encode(member.getPassw()));
    }
}
