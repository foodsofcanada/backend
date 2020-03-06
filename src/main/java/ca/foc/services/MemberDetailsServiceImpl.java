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
//        Member member = repository.findByEmail(email);
//        if (member == null) {
//            throw new UsernameNotFoundException(email);
//        }
//        return new User(member.getEmail(), member.getPassword(), Collections.emptyList());
//    }
//}
