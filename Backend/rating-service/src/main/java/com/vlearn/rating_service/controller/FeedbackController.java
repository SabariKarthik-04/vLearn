package com.vlearn.rating_service.controller;

import org.springframework.web.bind.annotation.RestController;

import com.vlearn.rating_service.dto.FeedbackReq;
import com.vlearn.rating_service.dto.FeedbackRes;
import com.vlearn.rating_service.service.FeedbackService;

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

    @PutMapping("update/{id}")
    public ResponseEntity<FeedbackRes> updateFeedback(@PathVariable Long id, @Valid @RequestBody FeedbackReq entity) {

        return ResponseEntity.ok().body(feedbackService.updateFeedback(id, entity));
    }
    
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteFeedback (@PathVariable Long id){
        feedbackService.deleteFeedback(id);
        return ResponseEntity.ok().build();
    }

}
