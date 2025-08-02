package com.skillmatch.vlearn.dto;

import com.skillmatch.vlearn.entity.Rating;

import lombok.Data;

@Data
public class RatingsResponse extends ResponseDTO {
	private Rating rating;
}
