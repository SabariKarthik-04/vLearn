package com.skillmatch.vlearn.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.AbstractRepositoryConfigurationSourceSupport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillmatch.vlearn.dto.RatingsRequest;
import com.skillmatch.vlearn.dto.RatingsResponse;
import com.skillmatch.vlearn.entity.Rating;
import com.skillmatch.vlearn.service.RatingService;

@RestController
@RequestMapping("/Ratings")
public class RatingsController {

	@Autowired
	private RatingService service;
	
	@PostMapping("/new-Rating")
	public ResponseEntity<RatingsResponse> saveRating(@RequestBody RatingsRequest rat){
		try {
			
			Rating rat_save=new Rating();
			rat_save.setBy_user_id(rat.getBy_user_id());
			rat_save.setFor_mentor_id(rat.getFor_mentor_id());
			rat_save.setComment(rat.getComment());
			rat_save.setStars(rat.getStars());
			RatingsResponse response = new RatingsResponse();
			Rating resp = service.saveNewRating(rat_save);
			if(resp==null) {
				response.setRating(null);
				response.setMsg("Error Occured While Saving");
				response.setStatus_code(HttpStatus.BAD_REQUEST.value());
				response.setTimestamp(LocalDateTime.now());
				response.setUserID(rat.getUserId());
			}else {
				response.setRating(resp);
				response.setMsg("Sucessfully Rated");
				response.setStatus_code(HttpStatus.OK.value());
				response.setTimestamp(LocalDateTime.now());
				response.setUserID(rat.getUserId());
			}
			return ResponseEntity.status(response.getStatus_code()).body(response); 
		} catch (Exception e) {
			throw e;
		}
	}
	
	
}
