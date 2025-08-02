package com.skillmatch.vlearn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillmatch.vlearn.entity.MeetingDetails;
import com.skillmatch.vlearn.repository.MeetingRepo;

@Service
public class MeetingService {
	
	@Autowired
	private UserDetailsService userService; 
	
	@Autowired
	private MeetingRepo repo;
	
	public MeetingDetails saveNewMeeting(MeetingDetails det) {
		try {
			MeetingDetails meetDet = repo.save(det);
			String learner = userService.saveMeetingDetailsForTheUserToLearn(det.getLearnerId(), det.getId());
			String mentor = userService.saveMeetingDetailsForTheUserToTeach(det.getMentorId(), det.getId());
			if(learner.equals("Failure") || mentor.equals("Failure")) {
				return null;
			}
			return meetDet;
		} catch (Exception e) {
			System.out.println("Error : "+e);
			throw e;
		}
	}
	
}
