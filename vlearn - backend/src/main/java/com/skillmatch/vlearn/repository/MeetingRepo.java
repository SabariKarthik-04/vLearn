package com.skillmatch.vlearn.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.skillmatch.vlearn.entity.MeetingDetails;

public interface MeetingRepo extends MongoRepository<MeetingDetails, String> {
	
}
