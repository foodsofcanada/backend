package ca.foc.secure;

import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

//import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

//import static ca.foc.secure.Constants.SECRET;
import static ca.foc.secure.Constants.EXPIRATION_TIME;
/**
 * JwtTokenUtil - ca.foc.secure.JwtTokenUtil
 */
//@Component
public class JwtTokenUtil {

//    Key key = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));
    Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    /* Retrieves username from jwt */
    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    /* Retrieves expiration date of jwt */
    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    /* Retrieves all Claims(keys) from a token. */
    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    /** Public method to generate a token based on the UserDetails passed in as the argument. */
    public String generateToken(UserDetails deets) {
        Map<String, Object> claims = new HashMap<>();
        return doGenerateToken(claims, deets.getUsername());
    }

    /** Generates a JWT token by defining the token claims,
    signing with the key and compacting JWT to be URL-safe
    * */
    private String doGenerateToken(Map<String, Object> claims, String subject) {
        return Jwts
                .builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME * 1000))
                .signWith(key).compact();
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

}
