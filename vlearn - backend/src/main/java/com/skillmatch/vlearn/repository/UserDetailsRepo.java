package com.skillmatch.vlearn.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.skillmatch.vlearn.entity.UserDetails;


public interface UserDetailsRepo extends MongoRepository<UserDetails, String>{
	@Query("{ 'user_id' : ?0 }")
	UserDetails findByUserId(String user_id);

}
