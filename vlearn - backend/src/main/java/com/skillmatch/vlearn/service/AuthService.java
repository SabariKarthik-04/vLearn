package com.skillmatch.vlearn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.skillmatch.vlearn.dto.AuthRequest;
import com.skillmatch.vlearn.entity.UserEntity;
import com.skillmatch.vlearn.repository.UserRepository;

@Service
public class AuthService {
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private CustomUserDetailsService details;
	
	@Autowired
	private JwtService jwtService;
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
	
	public UserEntity register(UserEntity user) {
		if(repo.findByEmail(user.getEmail()).isEmpty()) {
			user.setPassword(encoder.encode(user.getPassword()));
			return repo.save(user);
		}
		return null;
	}
	public String verify(AuthRequest user) {
		
		Authentication authentication = authManager
				.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		if(authentication.isAuthenticated()) {
			return jwtService.generateToken(user.getUsername());
		}
		return "fail";
				
	}
}
