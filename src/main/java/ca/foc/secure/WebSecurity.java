package ca.foc.secure;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * WebSecurity - ca.foc.secure.WebSecurity
 */
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
//    private MemberDetailsServiceImpl memberDetailsService;
    private BCryptPasswordEncoder bCrypt;

    public WebSecurity()
}
