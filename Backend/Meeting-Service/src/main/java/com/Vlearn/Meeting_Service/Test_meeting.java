package com.Vlearn.Meeting_Service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test_meeting {
	@GetMapping("/")
	public String hello() {
		return "Hello World From Meeting Service";
	}
}
