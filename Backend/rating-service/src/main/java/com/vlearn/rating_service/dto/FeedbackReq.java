package com.vlearn.rating_service.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class FeedbackReq {

    @NotNull
    private Long meetingId;
    
    @NotNull
    private Long mentorId;
    
    @NotNull
    private Long reviewerId;
    @NotNull
    private int rating;
    private String comment;
}
