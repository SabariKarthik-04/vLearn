package com.vlearn.rating_service.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class FeedbackReq {

    @NotNull
    private Long courseId;
    @NotNull
    private Long userId;
    @NotNull
    private int rating;
    private String comment;
}
