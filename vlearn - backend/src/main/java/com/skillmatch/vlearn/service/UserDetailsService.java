package com.skillmatch.vlearn.service;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillmatch.vlearn.entity.UserDetails;
import com.skillmatch.vlearn.repository.UserDetailsRepo;

@Service
public class UserDetailsService {

    @Autowired
    private UserDetailsRepo repo;

    public UserDetails saveOrUpdateDetails(UserDetails user) {
        if (user.getId() != null) {
            Optional<UserDetails> existingUserOpt = repo.findById(user.getId());
            if (existingUserOpt.isPresent()) {
                UserDetails existingUser = existingUserOpt.get();
                if (user.getAbout() != null) existingUser.setAbout(user.getAbout());
                if (user.getTimezone() != null) existingUser.setTimezone(user.getTimezone());
                existingUser.setSkills_known(user.getSkills_known() != null ? user.getSkills_known() : new ArrayList<>());
                existingUser.setSkills_like_to_learn(user.getSkills_like_to_learn() != null ? user.getSkills_like_to_learn() : new ArrayList<>());
                existingUser.setFree_days_willing_to_teach(user.getFree_days_willing_to_teach() != null ? user.getFree_days_willing_to_teach() : new ArrayList<>());
                existingUser.setFree_days_willing_to_learn(user.getFree_days_willing_to_learn() != null ? user.getFree_days_willing_to_learn() : new ArrayList<>());
                existingUser.setMeetingIdsToTeach(user.getMeetingIdsToTeach() != null ? user.getMeetingIdsToTeach() : new ArrayList<>());
                existingUser.setMeetingIdsToLearn(user.getMeetingIdsToLearn() != null ? user.getMeetingIdsToLearn() : new ArrayList<>());
                existingUser.setRatings_by_this_user(user.getRatings_by_this_user() != null ? user.getRatings_by_this_user() : new ArrayList<>());
                existingUser.setRatings_for_this_user(user.getRatings_for_this_user()!=null?user.getRatings_for_this_user():new ArrayList<>());
                return repo.save(existingUser);
            }
        }
        if (user.getSkills_known() == null) user.setSkills_known(new ArrayList<>());
        if (user.getSkills_like_to_learn() == null) user.setSkills_like_to_learn(new ArrayList<>());
        if (user.getFree_days_willing_to_teach() == null) user.setFree_days_willing_to_teach(new ArrayList<>());
        if (user.getFree_days_willing_to_learn() == null) user.setFree_days_willing_to_learn(new ArrayList<>());
        if (user.getMeetingIdsToTeach() == null) user.setMeetingIdsToTeach(new ArrayList<>());
        if (user.getMeetingIdsToLearn() == null) user.setMeetingIdsToLearn(new ArrayList<>());
        if (user.getRatings_by_this_user() == null) user.setRatings_by_this_user(null);
        if(user.getRatings_for_this_user()==null) user.setRatings_for_this_user(new ArrayList<>());
        user.setId(null);
        return repo.save(user);
    }
    
    public String saveRatingsForTheUser(String user_Id,String rating_Id) {
    	try {
    		UserDetails user = repo.findByUserId(user_Id);
        	if(user == null) {
        		return "Failure";
        	}else {
        		user.getRatings_for_this_user().add(rating_Id);
        		return repo.save(user).toString();
        	}
		} catch (Exception e) {
			throw e;
		}
    }
    public String saveRatingsByTheUser(String user_Id,String rating_Id) {
    	try {
    		UserDetails user = repo.findByUserId(user_Id);
        	if(user == null) {
        		return "Failure";
        	}else {
        		user.getRatings_by_this_user().add(rating_Id);
        		return repo.save(user).toString();
        	}
    	}catch (Exception e) {
    		throw e;
		}
    }		
    public String saveMeetingDetailsForTheUserToLearn(String userId,String meetingId) {
    	try {
    		UserDetails user = repo.findByUserId(userId);
        	if(user == null) {
        		return "Failure";
        	}else {
        		user.getMeetingIdsToLearn().add(meetingId);
        		return repo.save(user).toString();
        	}
    	}catch (Exception e) {
    		throw e;
		}
    }
    public String saveMeetingDetailsForTheUserToTeach(String userId,String meetingId) {
    	try {
    		UserDetails user = repo.findByUserId(userId);
        	if(user == null) {
        		return "Failure";
        	}else {
        		user.getMeetingIdsToTeach().add(meetingId);
        		return repo.save(user).toString();
        	}
    	}catch (Exception e) {
    		throw e;
		}
    }
}
