package com.Vlearn.Jwt_common;

import java.security.Key;
import java.util.Date;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JwtUtil {
	private static final String secretKey = "WwBl68SXAn7D3m4gW+KzE9gt43cqxE8SDr9U10jlg7N7whZnqxQJ5ZnmWWP/GKZz";
	private static final Key key = Keys.hmacShaKeyFor(secretKey.getBytes());
	private static final long EXPIRATION_TIME = 1000 * 60 * 60 * 24; 
	
	public String generateToken(String email) {
		return Jwts.builder()
				.setSubject(email)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()*EXPIRATION_TIME))
				.signWith(key)
				.compact();
		
	}
	
	 public String extractEmail(String token) {
	        return extractAllClaims(token).getSubject();
	    }
	 
	 public boolean isTokenExpired(String token) {
	        return extractAllClaims(token).getExpiration().before(new Date());
	    }
	 
	 public boolean validateToken(String token, String email) {
	        String extractedEmail = extractEmail(token);
	        return (email.equals(extractedEmail) && !isTokenExpired(token));
	    }
	 
	 private Claims extractAllClaims(String token) {
	        return Jwts.parserBuilder()
	                .setSigningKey(key)
	                .build()
	                .parseClaimsJws(token)
	                .getBody();
	    }
	 
}
