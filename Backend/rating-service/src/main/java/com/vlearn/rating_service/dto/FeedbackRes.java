package com.vlearn.rating_service.dto;

import lombok.Data;

@Data
public class FeedbackRes {
    private int rating;
    private String comment;
}
