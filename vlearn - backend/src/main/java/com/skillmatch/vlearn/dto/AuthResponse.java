package com.skillmatch.vlearn.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponse extends ResponseDTO{
    private String token;
}