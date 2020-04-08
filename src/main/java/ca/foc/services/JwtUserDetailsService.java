package ca.foc.services;

import ca.foc.dao.MemberRepository;
import ca.foc.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Implements the UserDetailsService class of Spring Security Core.
 * JwtUserDetailsService - ca.foc.services.JwtUserDetailsService
 */
//@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private MemberRepository repository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    /**
    Checks if a given username exists in the database
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("christian".equals(username)) {
            return new User("christian", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }

//    public MemberRepository save(Member member) {
//        member.setPassword(bcryptEncoder.encode(member.getPassword()));
//        return repository.save(member);
//    }
}
