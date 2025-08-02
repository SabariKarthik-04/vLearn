package com.skillmatch.vlearn.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "Ratings")
public class Rating {
	@Id
	private String id;
    private String by_user_id;
    private int stars;
    private String comment;
    private String for_mentor_id;
}