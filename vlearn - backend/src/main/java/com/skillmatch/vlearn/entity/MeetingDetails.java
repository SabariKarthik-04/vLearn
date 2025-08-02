package com.skillmatch.vlearn.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "Meeting_details")
public class MeetingDetails {
    @Id
    private String id;

    private String mentorId;           // user_id of the mentor
    private String learnerId;          // user_id of the learner
    private String skill;              // e.g., "Python", "React", etc.
    private LocalDateTime scheduledTime;
    private int durationMinutes;       // e.g., 30 or 60
    
    private String meetingPlatform;    // e.g., "Google Meet", "Zoom"
    private String meetingLink;
    
    private boolean isCompleted;
    private boolean isCancelled;
    
    private String feedbackFromTeacher;
    private String feedbackFromStudent;
    private Integer ratingByTeacher;
    private Integer ratingByStudent;

}

