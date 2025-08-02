package com.skillmatch.vlearn.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class MeetingRequest extends RequestDTO{
	
    private String mentorId;           
    private String learnerId;          
    private String skill;              
    private LocalDateTime scheduledTime;
    private int durationMinutes;       
    private String meetingPlatform;    
    private String meetingLink;
	
}
