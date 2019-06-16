package com.platformtechlab.authgateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    @Autowired
//    private AppUserRepository userRepository;

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
     
        auth.inMemoryAuthentication()
                .withUser("user3").password("test").roles("USER")
                .and()
                .withUser("user4").password("test").roles("ADMIN");

    }

    @SuppressWarnings("deprecation")
	@Bean
    public PasswordEncoder noOpPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
//    @Autowired
//    public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(new DefaultUserDetailsService(userRepository));
//    }
}
