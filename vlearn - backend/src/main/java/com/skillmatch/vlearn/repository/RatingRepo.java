package com.skillmatch.vlearn.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.skillmatch.vlearn.entity.Rating;

public interface RatingRepo extends MongoRepository<Rating, String> {
	
}
