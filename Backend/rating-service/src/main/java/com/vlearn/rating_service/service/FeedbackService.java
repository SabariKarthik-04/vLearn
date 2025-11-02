package com.vlearn.rating_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vlearn.rating_service.dto.feedbackDTOs.FeedBackResMentorId;
import com.vlearn.rating_service.dto.feedbackDTOs.FeedbackReq;
import com.vlearn.rating_service.dto.feedbackDTOs.FeedbackRes;
import com.vlearn.rating_service.entity.Feedback;
import com.vlearn.rating_service.mapper.FeedbackMapper;
import com.vlearn.rating_service.repo.FeedbackRepo;

@Service
public class FeedbackService implements FeedbackServiceInterface{


    private final FeedbackRepo feedbackRepo;

    public FeedbackService(FeedbackRepo feedbackRepo) {
        this.feedbackRepo = feedbackRepo;
    }

    public FeedbackRes createFeedback(FeedbackReq req){
        
        return FeedbackMapper.toDTO(feedbackRepo.save(FeedbackMapper.toEntity(req)));
    }

    public void deleteFeedback (Long feedbackId){
        feedbackRepo.deleteById(feedbackId);
    }
    
    public List<FeedBackResMentorId> getFeedbackByMentorId(String MentorId){
    	return feedbackRepo.feedBackByMentorId(MentorId);
    }
    
    public List<FeedbackRes> getAllFeedbacks (){
        return feedbackRepo.findAll().stream().map(FeedbackMapper::toDTO).toList();
    }

    public FeedbackRes updateFeedback (Long feedbackId,FeedbackReq feedbackReq){
        Optional<Feedback> op = feedbackRepo.findById(feedbackId);
        if (op.isPresent()){
            Feedback feedback = op.get();
            feedback.setRating(feedbackReq.getRating());
            feedback.setComment(feedbackReq.getComment());
            return FeedbackMapper.toDTO(feedbackRepo.save(feedback));
        }
        else {
            return null;
        }
    }

}