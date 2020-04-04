//package ca.foc.secure;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.algorithms.Algorithm;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.ArrayList;
//
//import static ca.foc.secure.Constants.*;
//
///**
// * JWTAuthorizationFilter - ca.foc.secure.JWTAuthorizationFilter
// */
//public class JWTAuthorizationFilter extends BasicAuthenticationFilter {
//
//    public JWTAuthorizationFilter(AuthenticationManager manager) {
//        super(manager);
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request,
//                                   HttpServletResponse response,
//                                   FilterChain chain) {
//        String header = request.getHeader(HEADER_STRING);
//
//        try {
//            if (header == null || !header.startsWith(TOKEN_PREFIX)) {
//                chain.doFilter(request, response);
//                return;
//            }
//
//            UsernamePasswordAuthenticationToken authentication = getAuthentication(request);
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//            chain.doFilter(request, response);
//        } catch (ServletException | IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
//        String token = request.getHeader(HEADER_STRING);
//        if (token != null) {
//            String member = JWT.require(Algorithm.HMAC512(SECRET.getBytes()))
//                    .build()
//                    .verify(token.replace(TOKEN_PREFIX, ""))
//                    .getSubject();
//
//            if (member != null) {
//                return new UsernamePasswordAuthenticationToken(member, null, new ArrayList<>());
//            }
//            return null;
//        }
//        return null;
//    }
//}
