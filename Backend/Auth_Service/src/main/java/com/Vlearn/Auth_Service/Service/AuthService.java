package com.Vlearn.Auth_Service.Service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Vlearn.Auth_Service.Entity.UserEntity;
import com.Vlearn.Auth_Service.Exception.InvalidEmailPassException;
import com.Vlearn.Auth_Service.Exception.RegisterException;
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
	
	public String register(UserEntity user) throws Exception {
		String token ="";
		try {
			if(user != null) {
				String hashedPass = passwordEncoder.encode(user.getPassword());
				token = jUtil.generateToken(user.getEmail());
				if(token.isEmpty()) throw new Exception("Someting went Wrong");
				user.setPassword(hashedPass);
				user.setToken(token);
				user.setTtl(LocalDate.now().plusDays(1));
				repo.save(user);
				return token;
			}else {
				throw new RegisterException("User Data Null", "Please enter user details");
			}
		} catch (Exception e) {
			throw e;
		}
		
	}
	
	public String login(String email, String password) throws Exception {
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
                }else {
                	throw new InvalidEmailPassException("Invalid password try another.", "Invalid password");
                }
            }else {
            	throw new InvalidEmailPassException("Invalid email try another.", "Invalid email");
            }
		} catch (Exception e) {
			throw e;
		}
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
        
        try {
        	Optional<UserEntity> optionalUser = repo.findByEmail(email);
        	if (optionalUser.isPresent()) {
                UserEntity user = optionalUser.get();
                user.setToken("null");
                user.setTtl(null);
                repo.save(user);
            }
		} catch (Exception e) {
			throw e;
		}
    }
	
}
