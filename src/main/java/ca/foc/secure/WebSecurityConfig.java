package ca.foc.secure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * WebSecurityConfig - ca.foc.secure.WebSecurityConfig
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Qualifier("inMemoryUserDetailsManager")
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtRequestFilter requestFilter;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        /* Configure AuthenticationManager to know where to load the user that matches credentials*/
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(4);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                //always authorize the following requests
                .authorizeRequests()
                .antMatchers("/products/*", "/productRegion/*", "/authenticate", "/region/*")
                .permitAll()

                //Any other requests need to be authenticated
                .anyRequest().authenticated().and()
                //Use a stateless session; session won't be used to store the users state
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        //Add a filter to validate tokens with every request made
        httpSecurity.addFilterBefore(requestFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
