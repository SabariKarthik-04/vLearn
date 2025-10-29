package com.Vlearn.Auth_Service.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
public class UserEntity {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    private String token = "null";
    private LocalDate ttl;
}
