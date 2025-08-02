package com.skillmatch.vlearn.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillmatch.vlearn.dto.UserDetailsPostRequest;
import com.skillmatch.vlearn.dto.UserDetailsResponse;
import com.skillmatch.vlearn.entity.UserDetails;
import com.skillmatch.vlearn.service.UserDetailsService;

@RestController
@RequestMapping("/user")
public class UserDetailsController {
	
	@Autowired
	private UserDetailsService service;
	
	@PostMapping("/post-user-details")
	public ResponseEntity<UserDetailsResponse> post_user_details(@RequestBody UserDetailsPostRequest userDetails){
		UserDetailsResponse res = new UserDetailsResponse();
		if(userDetails==null) {
			res.setUserID("-1");
			res.setUser(null);
			res.setTimestamp(LocalDateTime.now());
			res.setStatus_code(HttpStatus.BAD_REQUEST.value());
			res.setMsg("Data is null");
		}
		else{
		UserDetails user = new UserDetails(
			    "S",
			    userDetails.getUserId(),
			    userDetails.getAbout(),
			    userDetails.getTimezone(),
			    userDetails.getSkills_known() != null ? userDetails.getSkills_known() : new ArrayList<>(),
			    userDetails.getSkills_like_to_learn() != null ? userDetails.getSkills_like_to_learn() : new ArrayList<>(),
			    userDetails.getFree_days_willing_to_teach() != null ? userDetails.getFree_days_willing_to_teach() : new ArrayList<>(),
			    userDetails.getFree_days_willing_to_learn() != null ? userDetails.getFree_days_willing_to_learn() : new ArrayList<>(),
			    userDetails.getMeetingIdsToTeach() != null ? userDetails.getMeetingIdsToTeach() : new ArrayList<>(),
			    userDetails.getMeetingIdsToLearn() != null ? userDetails.getMeetingIdsToLearn() : new ArrayList<>(),
			    userDetails.getRatings_by_this_user() != null ? userDetails.getRatings_by_this_user() : new ArrayList<>(),
			    userDetails.getRatings_for_this_user() != null ? userDetails.getRatings_for_this_user() : new ArrayList<>()		
			);
			user.setId(null);
			UserDetails resp = service.saveOrUpdateDetails(user);
			res.setUserID(resp.getUser_id());
			res.setUser(resp);
			res.setTimestamp(LocalDateTime.now());
			res.setStatus_code(HttpStatus.ACCEPTED.value());
			res.setMsg("Data Stored Successfully");
		}
		return ResponseEntity.status(res.getStatus_code()).body(res);
	}
	
}
