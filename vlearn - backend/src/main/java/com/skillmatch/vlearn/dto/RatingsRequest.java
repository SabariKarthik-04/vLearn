package com.skillmatch.vlearn.dto;

import lombok.Data;

@Data
public class RatingsRequest extends RequestDTO {
    private String by_user_id;
    private int stars;
    private String comment;
    private String for_mentor_id;
    
}
