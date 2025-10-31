package com.vlearn.rating_service.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class FeedbackReq {

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
