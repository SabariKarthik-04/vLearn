package com.vlearn.rating_service.dto.feedbackDTOs;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.vlearn.rating_service.entity.Feedback;
import com.vlearn.rating_service.mapper.FeedbackMapper;

public class ResponseBuilder {
    public static FeedbackResIdList feedbackMentorIdListBuilder(List<FeedBackResId> li , HttpStatus code , String msg){
        FeedbackResIdList resp = new FeedbackResIdList();
        resp.setFeedbacks(li);
        		resp.setHttpStatus(code.name());
        		resp.setHttpStatusCode(code.value());
        		resp.setMessage(msg);
        		resp.setTimeStamp(LocalDateTime.now());
        return resp;
    }

    public static FeedbackRes feedbackResBuilder (Feedback feedback,HttpStatus status , String message){
        FeedbackRes feedbackRes = FeedbackMapper.toDTO(feedback);

        feedbackRes.setHttpStatus(status.name());
        feedbackRes.setHttpStatusCode(status.value());
        feedbackRes.setMessage(message);
        feedbackRes.setTimeStamp(LocalDateTime.now());

        return feedbackRes;

    }
}
