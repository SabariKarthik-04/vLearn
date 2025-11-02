package com.vlearn.rating_service.dto.feedbackDTOs;

import com.vlearn.rating_service.dto.ResponseDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class FeedbackRes extends ResponseDTO {
	private Long feedbackId;
    private int rating;
    private String comment;
}
