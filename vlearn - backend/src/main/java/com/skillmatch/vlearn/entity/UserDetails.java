package com.skillmatch.vlearn.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@Document(collection = "User_details")
public class UserDetails {
	@Id
	private String id;
	private String user_id;
	private String about;
	private String timezone;
	private List<String> skills_known;
	private List<String> skills_like_to_learn;
	private List<String> free_days_willing_to_teach;
	private List<String> free_days_willing_to_learn;
	private List<String> meetingIdsToTeach;
	private List<String> meetingIdsToLearn;
	private List<String> ratings_for_this_user;
	private List<String> ratings_by_this_user;
}



