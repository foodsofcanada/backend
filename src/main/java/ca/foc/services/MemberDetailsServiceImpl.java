<<<<<<< HEAD
package ca.foc.services;

import ca.foc.dao.MemberRepository;
import ca.foc.domain.Member;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

/**
 * MemberDetailsServiceImpl - ca.foc.services.MemberDetailsServiceImpl
 */
@Service
public class MemberDetailsServiceImpl implements UserDetailsService {
    private MemberRepository repository;

    public MemberDetailsServiceImpl(MemberRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) {
=======
//package ca.foc.services;
//
//import ca.foc.dao.MemberRepository;
//import ca.foc.domain.Member;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Collections;
//
///**
// * MemberDetailsServiceImpl - ca.foc.services.MemberDetailsServiceImpl
// */
//@Service
//public class MemberDetailsServiceImpl implements UserDetailsService {
//    private MemberRepository repository;
//
//    public MemberDetailsServiceImpl(MemberRepository repository) {
//        this.repository = repository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String email) {
>>>>>>> 79eee4885511826072a8f4f6a2c6d3ce5d3fa37f
//        Member member = repository.findByEmail(email);
//        if (member == null) {
//            throw new UsernameNotFoundException(email);
//        }
<<<<<<< HEAD
    	Optional <Member> member= repository.findByEmail(email);
    	if (!member.isPresent()) {
    		throw new UsernameNotFoundException(email);
			}
		
    	Member memberDb= member.get();	
        return new User(memberDb.getEmail(), memberDb.getPassword(), Collections.emptyList());
    }
}
=======
//        return new User(member.getEmail(), member.getPassword(), Collections.emptyList());
//    }
//}
>>>>>>> 79eee4885511826072a8f4f6a2c6d3ce5d3fa37f
