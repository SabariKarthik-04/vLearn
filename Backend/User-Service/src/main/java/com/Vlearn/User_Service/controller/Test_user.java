package com.Vlearn.User_Service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test_user {
	
	@GetMapping("/")
	public String hello() {
		return "Hello World form User service";
	}
}
