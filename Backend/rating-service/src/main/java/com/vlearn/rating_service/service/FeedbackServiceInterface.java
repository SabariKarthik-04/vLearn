package com.vlearn.rating_service.service;

import java.util.List;


import com.vlearn.rating_service.dto.feedbackDTOs.FeedBackResMentorId;
import com.vlearn.rating_service.dto.feedbackDTOs.FeedbackReq;
import com.vlearn.rating_service.dto.feedbackDTOs.FeedbackRes;


public interface FeedbackServiceInterface {
	public FeedbackRes createFeedback(FeedbackReq req);
	public void deleteFeedback (Long feedbackId);       
    public List<FeedBackResMentorId> getFeedbackByMentorId(String MentorId);
    public List<FeedbackRes> getAllFeedbacks ();
    public FeedbackRes updateFeedback (Long feedbackId,FeedbackReq feedbackReq);
}
