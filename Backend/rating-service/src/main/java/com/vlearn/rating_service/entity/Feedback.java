package com.vlearn.rating_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Feedback {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long meetingId;
    
    @NotNull
    private Long mentorId;
    
    @NotNull
    private Long reviewerId;

    private String comment;
    @NotNull
    private int rating;

}