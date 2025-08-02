package com.skillmatch.vlearn.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillmatch.vlearn.dto.MeetingRequest;
import com.skillmatch.vlearn.dto.MeetingResponse;
import com.skillmatch.vlearn.entity.MeetingDetails;
import com.skillmatch.vlearn.service.MeetingService;

@RestController
@RequestMapping("/Meetings")
public class MeetingsController {
	
	@Autowired
	private MeetingService service;
	
	@PostMapping("/new_meet")
	public ResponseEntity<MeetingResponse> newMeet(@RequestBody MeetingRequest meet){
		try {
			MeetingDetails new_meet = new MeetingDetails();
			new_meet.setLearnerId(meet.getLearnerId());
			new_meet.setMentorId(meet.getMentorId());
			new_meet.setSkill(meet.getSkill());
			new_meet.setMeetingPlatform(meet.getMeetingPlatform());
			new_meet.setMeetingLink(meet.getMeetingLink());
			new_meet.setDurationMinutes(meet.getDurationMinutes());
			new_meet.setCancelled(false);
			new_meet.setCompleted(false);
			new_meet.setRatingByStudent(null);
			new_meet.setRatingByTeacher(null);
			MeetingResponse resp = new MeetingResponse();
			MeetingDetails savedDet = service.saveNewMeeting(new_meet);
			if(savedDet == null) {
				resp.setUserID(meet.getUserId());
				resp.setMsg("Error Occured While Saving Meeting Details");
				resp.setStatus_code(HttpStatus.BAD_REQUEST.value());
				resp.setResp(null);
				resp.setTimestamp(LocalDateTime.now());
			}else {
				resp.setUserID(meet.getUserId());
				resp.setMsg("Meeting Details Saved Successfully");
				resp.setStatus_code(HttpStatus.OK.value());
				resp.setResp(savedDet);
				resp.setTimestamp(LocalDateTime.now());
			}
			return ResponseEntity.status(resp.getStatus_code()).body(resp);
		} catch (Exception e) {
			throw e;
		}
	}
}
