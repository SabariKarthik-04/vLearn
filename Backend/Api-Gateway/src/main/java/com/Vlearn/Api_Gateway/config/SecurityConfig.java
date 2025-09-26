package com.Vlearn.Api_Gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http
			    .cors(cors -> cors.disable()) 
			    .csrf(csrf -> csrf.disable()) 
			    .authorizeHttpRequests(req -> req.anyRequest().permitAll())
			    .build();
	}
	
}
