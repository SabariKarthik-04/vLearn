package com.vlearn.rating_service.service.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.vlearn.rating_service.dto.feedbackDTOs.FeedBackResId;
import com.vlearn.rating_service.dto.feedbackDTOs.FeedbackResIdList;
import com.vlearn.rating_service.dto.feedbackDTOs.FeedbackReq;
import com.vlearn.rating_service.dto.feedbackDTOs.FeedbackRes;
import com.vlearn.rating_service.dto.feedbackDTOs.ResponseBuilder;
import com.vlearn.rating_service.entity.Feedback;
import com.vlearn.rating_service.exception.MentorNotFoundException;
import com.vlearn.rating_service.mapper.FeedbackMapper;
import com.vlearn.rating_service.repo.FeedbackRepo;
import com.vlearn.rating_service.service.FeedbackService;

@Component
public class FeedbackServiceImpl implements FeedbackService{

    private final FeedbackRepo feedbackRepo;


    public FeedbackServiceImpl(FeedbackRepo feedbackRepo) {
        this.feedbackRepo = feedbackRepo;
    }
    
    @Override
    public FeedbackRes createFeedback (FeedbackReq req){
        Feedback feedback = feedbackRepo.save(FeedbackMapper.toEntity(req));

        return ResponseBuilder.feedbackResBuilder(feedback , HttpStatus.CREATED, "New user created : " + feedback.getId());
    }

    @Override
    public void deleteFeedback (Long feedbackId){
        feedbackRepo.deleteById(feedbackId);        
    }
    @Override
    public FeedbackResIdList getFeedbackByMentorId(String mentorId){
        try {
    		List<FeedBackResId> li = feedbackRepo.feedBackByMentorId(mentorId);
        	if(li == null ){
                throw new MentorNotFoundException("Mentor not found for this ID "+mentorId);
            }else if(li.isEmpty()) {
            	return ResponseBuilder.feedbackMentorIdListBuilder(li, HttpStatus.ACCEPTED, "There are no ratings for this mentor : "+mentorId);
        	}else{
                return ResponseBuilder.feedbackMentorIdListBuilder(li, HttpStatus.ACCEPTED, "Retrived all rating of this mentor : "+mentorId);
        	}
		} catch (Exception e) {
            return ResponseBuilder.feedbackMentorIdListBuilder(null, HttpStatus.BAD_REQUEST, "An error occured while retriving this mentor's ratings : "+mentorId);
		}
    }
    
    @Override
    public List<FeedbackRes> getAllFeedbacks (){
        return feedbackRepo.findAll().stream().map(FeedbackMapper::toDTO).toList();
    }

    @Override
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

    @Override
    public FeedbackResIdList getFeedbackByReviewerId(String reviewerId) {
        throw new UnsupportedOperationException("Unimplemented method 'getFeedbackByReviewerId'");
    }

}
