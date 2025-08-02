package com.skillmatch.vlearn.service;

import java.io.Console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillmatch.vlearn.entity.Rating;
import com.skillmatch.vlearn.repository.RatingRepo;

@Service
public class RatingService {
	
	@Autowired
	private UserDetailsService userService;
	
	@Autowired
	private RatingRepo repo;
	
	public Rating saveNewRating(Rating rat) {
		try {
			Rating rating = repo.save(rat);
			String learner = userService.saveRatingsByTheUser(rat.getBy_user_id(), rat.getId());
			String mentor = userService.saveRatingsForTheUser(rat.getFor_mentor_id(), rat.getId());
			if(learner.equals("Failure") || mentor.equals("Failure")) {
				return null;
			}
			return rating;
		}catch(Exception e) {
			System.out.println("Error : "+e);
			throw e;
		}
	}
}
