package com.vlearn.rating_service.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vlearn.rating_service.dto.FeedBackResMentorId;

import com.vlearn.rating_service.entity.Feedback;

@Repository
public interface FeedbackRepo extends JpaRepository<Feedback, Long> {
	@Query(
			  value = "SELECT id, rating, comment FROM feedbackdb.feedback WHERE mentor_id = :mentorId",
			  nativeQuery = true
			)
			List<FeedBackResMentorId> feedBackByMentorId(@Param("mentorId") String mentorId);

}
