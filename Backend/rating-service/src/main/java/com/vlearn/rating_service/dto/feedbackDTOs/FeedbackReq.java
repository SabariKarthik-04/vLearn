package com.vlearn.rating_service.dto.feedbackDTOs;

import com.vlearn.rating_service.dto.RequestDTO;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;



@Data
@EqualsAndHashCode(callSuper = false)
public class FeedbackReq extends RequestDTO{

    @NotNull
    private String meetingId;
    
    @NotNull
    private String mentorId;
    
    @NotNull
    private String reviewerId;
    @NotNull
    private int rating;
    private String comment;
}
