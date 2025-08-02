package com.skillmatch.vlearn.dto;

import com.skillmatch.vlearn.entity.MeetingDetails;

import lombok.Data;

@Data
public class MeetingResponse extends ResponseDTO{
	private MeetingDetails resp;
}
