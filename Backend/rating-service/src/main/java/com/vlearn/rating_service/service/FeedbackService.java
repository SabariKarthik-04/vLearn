package com.vlearn.rating_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vlearn.rating_service.dto.feedbackDTOs.FeedbackResIdList;
import com.vlearn.rating_service.dto.feedbackDTOs.FeedbackReq;
import com.vlearn.rating_service.dto.feedbackDTOs.FeedbackRes;

@Service
public interface FeedbackService {


    FeedbackRes createFeedback (FeedbackReq req);

    void deleteFeedback (Long feedbackId);
    
    FeedbackResIdList getFeedbackByMentorId(String mentorId);

    FeedbackResIdList getFeedbackByReviewerId(String reviewerId);
    
    List<FeedbackRes> getAllFeedbacks ();

    FeedbackRes updateFeedback (Long feedbackId,FeedbackReq feedbackReq);


}