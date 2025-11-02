package com.vlearn.rating_service.dto.feedbackDTOs;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FeedBackResId {
	private Long feedbackId;
    private int rating;
    private String comment;
}
