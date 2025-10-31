package com.vlearn.rating_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FeedBackResMentorId {
	private Long feedbackId;
    private int rating;
    private String comment;
}
