package com.enderecoapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	
		http.authorizeRequests()
		.antMatchers("/usuario/**").permitAll()
		.antMatchers("/enderecos").permitAll()
		.antMatchers("/endereco/**").hasRole("ADMIN")
		.anyRequest()
		.authenticated()
		.and()
		.csrf().disable()
		.formLogin()
		.loginPage("/login")
		.permitAll()
		.and().exceptionHandling().accessDeniedPage("/negado");
		
		return http.build();
    }
    
}
