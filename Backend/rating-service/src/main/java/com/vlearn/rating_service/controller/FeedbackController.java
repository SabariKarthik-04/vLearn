package com.vlearn.rating_service.controller;

import org.springframework.web.bind.annotation.RestController;

import com.vlearn.rating_service.dto.feedbackDTOs.FeedBackResMentorId;
import com.vlearn.rating_service.dto.feedbackDTOs.FeedbackMentorIdList;
import com.vlearn.rating_service.dto.feedbackDTOs.FeedbackReq;
import com.vlearn.rating_service.dto.feedbackDTOs.FeedbackRes;
import com.vlearn.rating_service.service.FeedbackService;

import jakarta.validation.Valid;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
public class FeedbackController {
    private final FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @GetMapping
    public ResponseEntity<List<FeedbackRes>> getAllFeedbacks() {
        return ResponseEntity.ok().body(feedbackService.getAllFeedbacks());
    }
    
    @PostMapping
    public ResponseEntity<FeedbackRes> createFeedback(@Valid @RequestBody FeedbackReq entity) {
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(feedbackService.createFeedback(entity));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<FeedbackRes> updateFeedback(@PathVariable Long id, @Valid @RequestBody FeedbackReq entity) {

        return ResponseEntity.ok().body(feedbackService.updateFeedback(id, entity));
    }
    
    @GetMapping("/getByMentorId/{id}")
    public ResponseEntity<FeedbackMentorIdList> getByMentorId(@PathVariable String id){
    	FeedbackMentorIdList resp = new FeedbackMentorIdList();
    	try {
    		List<FeedBackResMentorId> li = feedbackService.getFeedbackByMentorId(id);
        	if(li == null || li.isEmpty()) {
        		resp.setFeedbacks(li);
        		resp.setHttpStatus(HttpStatus.ACCEPTED.name());
        		resp.setHttpStatusCode(HttpStatus.ACCEPTED.value());
        		resp.setMessage("There are no ratings for this mentor : "+id);
        		resp.setTimeStamp(LocalDateTime.now());
        	}else {
        		resp.setFeedbacks(li);
        		resp.setHttpStatus(HttpStatus.ACCEPTED.name());
        		resp.setHttpStatusCode(HttpStatus.ACCEPTED.value());
        		resp.setMessage("Retrived all rating of this mentor : "+id);
        		resp.setTimeStamp(LocalDateTime.now());
        	}
		} catch (Exception e) {
			resp.setFeedbacks(null);
    		resp.setHttpStatus(HttpStatus.BAD_REQUEST.name());
    		resp.setHttpStatusCode(HttpStatus.BAD_REQUEST.value());
    		resp.setMessage("An error occured while retriving this mentor's ratings : "+id);
    		resp.setTimeStamp(LocalDateTime.now());
		}
    	return ResponseEntity.status(resp.getHttpStatusCode()).body(resp);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteFeedback (@PathVariable Long id){
        feedbackService.deleteFeedback(id);
        return ResponseEntity.ok().build();
    }

}
