package com.skillmatch.vlearn.dto;

import java.util.List;

import com.skillmatch.vlearn.entity.Rating;


import lombok.Data;

@Data
public class UserDetailsPostRequest extends RequestDTO {
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
