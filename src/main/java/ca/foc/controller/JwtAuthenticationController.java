package ca.foc.controller;

import ca.foc.domain.Member;
import ca.foc.secure.JwtResponse;
import ca.foc.secure.JwtTokenUtil;
import ca.foc.services.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

/**
 * JwtAuthenticationController - ca.foc.controller.JwtAuthenticationController
 */
@RestController
@CrossOrigin
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtTokenUtil tokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @PostMapping( path = "/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody Member member) {
        authenticate(member.getEmail(),member.getPassword());
        final UserDetails userDeets = userDetailsService.loadUserByUsername(member.getEmail());
        final String token = tokenUtil.generateToken(userDeets);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(String username, String password) {
        try {
            authManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            e.printStackTrace();
        }
    }
}
