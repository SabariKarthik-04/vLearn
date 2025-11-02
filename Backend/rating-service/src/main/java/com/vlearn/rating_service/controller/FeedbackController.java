package com.vlearn.rating_service.controller;

import org.springframework.web.bind.annotation.RestController;

import com.vlearn.rating_service.dto.feedbackDTOs.FeedbackResIdList;
import com.vlearn.rating_service.dto.feedbackDTOs.FeedbackReq;
import com.vlearn.rating_service.dto.feedbackDTOs.FeedbackRes;
import com.vlearn.rating_service.service.FeedbackService;
import com.vlearn.rating_service.service.FeedbackServiceInterface;

import jakarta.validation.Valid;

import java.util.List;

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
    private final FeedbackServiceInterface feedbackService;

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
    public ResponseEntity<FeedbackResIdList> getByMentorId(@PathVariable String id){
    	FeedbackResIdList resp = new FeedbackResIdList();
    	
    	return ResponseEntity.status(resp.getHttpStatusCode()).body(resp);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteFeedback (@PathVariable Long id){
        feedbackService.deleteFeedback(id);
        return ResponseEntity.ok().build();
    }

}
