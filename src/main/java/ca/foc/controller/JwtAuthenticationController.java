package ca.foc.controller;

import ca.foc.domain.Member;
import ca.foc.secure.JwtRequest;
import ca.foc.secure.JwtRequestFilter;
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
//@RestController
//@CrossOrigin(origins = "*")
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtTokenUtil tokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @CrossOrigin
    @RequestMapping( value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest request) {
        System.out.println("Request Received");
        authenticate(request.getUsername(),request.getPassword());
        final UserDetails userDeets = userDetailsService.loadUserByUsername(request.getUsername());
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
