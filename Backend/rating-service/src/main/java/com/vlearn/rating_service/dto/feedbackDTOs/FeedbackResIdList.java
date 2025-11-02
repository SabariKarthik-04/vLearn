package com.vlearn.rating_service.dto.feedbackDTOs;

import java.util.List;

import com.vlearn.rating_service.dto.ResponseDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class FeedbackResIdList extends ResponseDTO{
	private List<FeedBackResId> feedbacks;
}
