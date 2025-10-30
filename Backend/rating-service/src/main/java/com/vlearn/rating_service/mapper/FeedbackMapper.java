package com.vlearn.rating_service.mapper;


import com.vlearn.rating_service.dto.FeedbackReq;
import com.vlearn.rating_service.dto.FeedbackRes;
import com.vlearn.rating_service.entity.Feedback;


public class FeedbackMapper {

    public static Feedback toEntity(FeedbackReq feedbackReq){
        Feedback feedback  = new Feedback();

        feedback.setMeetingId(feedbackReq.getMeetingId());
        feedback.setReviewerId(feedbackReq.getReviewerId());
        feedback.setReviewerId(feedbackReq.getReviewerId());
        feedback.setRating(feedbackReq.getRating());
        feedback.setComment(feedbackReq.getComment());

        return feedback;
    }

    public static FeedbackRes toDTO(Feedback feedback){
        FeedbackRes feedbackRes = new FeedbackRes();

        feedbackRes.setRating(feedback.getRating());
        feedbackRes.setComment(feedback.getComment());

        return feedbackRes;
    }
}
