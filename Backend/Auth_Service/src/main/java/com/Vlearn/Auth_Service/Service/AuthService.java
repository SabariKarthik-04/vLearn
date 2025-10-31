package com.Vlearn.Auth_Service.Service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Vlearn.Auth_Service.Entity.UserEntity;
import com.Vlearn.Auth_Service.config.jwtUtil;
import com.Vlearn.Auth_Service.repository.UserRepository;

@Service
public class AuthService {
	
	@Autowired 
	private jwtUtil jUtil;
	
	@Autowired 
	private UserRepository repo;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	public String register(UserEntity user) {
		String token ="";
		try {
			if(user != null) {
				String hashedPass = passwordEncoder.encode(user.getPassword());
				token = jUtil.generateToken(user.getEmail());
				user.setPassword(hashedPass);
				user.setToken(token);
				user.setTtl(LocalDate.now().plusDays(1));
				repo.save(user);
			}
		} catch (Exception e) {
			return e.getMessage();
		}
		return token;
	}
	
	public String login(String email, String password) {
		Optional<UserEntity> optionalUser = repo.findByEmail(email);
        try {
        	if (optionalUser.isPresent()) {
                UserEntity user = optionalUser.get();
                
                if (passwordEncoder.matches(password, user.getPassword())) {
                    String token = jUtil.generateToken(email);
                    user.setToken(token);
                    user.setTtl(LocalDate.now().plusDays(1)); 
                    repo.save(user);
                    return token;
                }
            }
		} catch (Exception e) {
			throw e;
		}
        return "Invalid email or password";
	}
	
	public boolean validateToken(String token) {
        String email = jUtil.extractEmail(token);
        Optional<UserEntity> optionalUser = repo.findByEmail(email);
        if (optionalUser.isPresent()) {
            UserEntity user = optionalUser.get();
            System.out.println(user.getToken().equals(token) && jUtil.validateToken(token, email));
            return user.getToken().equals(token) && jUtil.validateToken(token, email);
        }
        return false;
    }	
	
	public void logout(String email) {
        Optional<UserEntity> optionalUser = repo.findByEmail(email);
        if (optionalUser.isPresent()) {
            UserEntity user = optionalUser.get();
            user.setToken("null");
            user.setTtl(null);
            repo.save(user);
        }
    }
	
}
