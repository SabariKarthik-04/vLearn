package com.Vlearn.Auth_Service.config;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.Vlearn.Auth_Service.Entity.UserEntity;
import com.Vlearn.Auth_Service.repository.UserRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter {

	@Autowired
	private jwtUtil jUtil;
	
	@Autowired
	private UserRepository repo;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		final String authHeader = request.getHeader("Authorization");
		String token = null;
        String email = null;
        
        if(authHeader != null && authHeader.startsWith("Bearer ")) {
        	token = authHeader.substring(7);
            try {
                email = jUtil.extractEmail(token);
            } catch (Exception e) {
                System.out.println("Invalid JWT: " + e.getMessage());
            }
        }
		
        if(email != null && SecurityContextHolder.getContext().getAuthentication()==null) {
        	UserEntity user = repo.findByEmail(email).orElse(null);
        	if(user!=null && 
        			user.getToken().equals(token) && 
        			user.getTtl()!=null && 
        			user.getTtl().isAfter(LocalDate.now()) && 
        			jUtil.validateToken(token, email)) {
        		
        		UserDetails userDetails = new User(user.getEmail(),
                        user.getPassword(), Collections.emptyList());
        		
        		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(user,null, userDetails.getAuthorities());
        		
        		authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        		
        		SecurityContextHolder.getContext().setAuthentication(authToken);
        		}
        }
        filterChain.doFilter(request, response);
	}
}
