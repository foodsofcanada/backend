package ca.foc.secure;

import ca.foc.services.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static ca.foc.secure.Constants.HEADER_STRING;
/**
 * Extends Spring Web OncePerRequestFilter class.
 * For any incoming request, this filter is executed. It checks if the request
 * has a valid JWT token and sets the Authentication in the context--which specifies that
 * the user is authenticated.
 * JwtRequestFilter - ca.foc.secure.JwtRequestFilter
 */
//@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private JwtTokenUtil tokenUtil;

    public JwtRequestFilter(JwtTokenUtil jwtTokenUtil) {
        this.tokenUtil = jwtTokenUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {
        final String requestTokenHeader = request.getHeader(HEADER_STRING);

        String username = null;
        String token = null;

        /* Get the token from the request header. The token is located after the token prefix of "Bearer " */
        if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
            token = requestTokenHeader.substring(7);
            username = tokenUtil.getUsernameFromToken(token);
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() != null) {
            UserDetails deets = userDetailsService.loadUserByUsername(username);

            /* If token is valid, configure Spring to manually config authentication*/
            if (tokenUtil.validateToken(token, deets)) {
                UsernamePasswordAuthenticationToken userPassToken =
                        new UsernamePasswordAuthenticationToken(deets, null, deets.getAuthorities());

                /* Set details adds additional details to the request. -- This is all the javadocs have*/
                userPassToken.setDetails(new WebAuthenticationDetails(request));

                /* Set authentication in context--which specifies that the user is now authenticated*/
                SecurityContextHolder.getContext().setAuthentication(userPassToken);
            }
        }
        chain.doFilter(request, response);
    }
}
