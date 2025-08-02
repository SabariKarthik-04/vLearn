package com.skillmatch.vlearn.service;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
	
	private String secertKey = "68147d174eaa106a83fb39a7f1978ec8591a0cf6c82059225fba763f91a5ad125419fe48cd0a3e3e551a1e2cb0e71fa4b7d0abc78526167bd8c1e6695addfb51";
	public String generateToken(String username) {
		Map<String,Object> claims=new HashMap<>();
		return Jwts.builder()
				.addClaims(claims)
				.setSubject(username)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000L * 60 * 60 * 30))
				.signWith(getKey(),SignatureAlgorithm.HS256)
				.compact();
	}
	private Key getKey() {
		byte[] keyBytes = Decoders.BASE64.decode(secertKey);
		return Keys.hmacShaKeyFor(keyBytes);
	}
	public String extractUsername(String token) {
		
		return extractClaim(token,Claims::getSubject);
	}
	private <T> T extractClaim(String token, Function<Claims,T> claimResolver) {
		final Claims claims = extractAllClaims(token);
		return claimResolver.apply(claims);
		
	}
	private Claims extractAllClaims(String token) {
		return Jwts.parserBuilder()
				.setSigningKey(getKey())
				.build().parseClaimsJws(token).getBody();
	}
	public boolean validateToken(String token, UserDetails userDetails) {
		final String userName = extractUsername(token);
		return (userName.equals(userDetails.getUsername()) &&!isTokenExpired(token));
	}
	private boolean isTokenExpired(String token) {
		return extractEpiration(token).before(new Date());
	}
	private Date extractEpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}
}
