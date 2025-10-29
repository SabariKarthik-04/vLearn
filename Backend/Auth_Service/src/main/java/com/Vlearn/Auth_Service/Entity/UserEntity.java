package com.Vlearn.Auth_Service.Entity;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "users")
public class UserEntity {
	@Id
	private String id;
    private String email;
    private String password;
    private String token = "null";
    private LocalDate ttl;
}
