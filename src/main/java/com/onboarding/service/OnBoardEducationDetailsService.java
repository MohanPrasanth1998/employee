package com.onboarding.service;

import java.util.List;

import com.onboarding.dto.OnBoardEducationDetailsDto;
import com.onboarding.model.OnBoardEducationDetails;
import com.onboarding.model.OnBoardReference;



public interface OnBoardEducationDetailsService {
	
	boolean saveOnBoardEducationDetails(List<OnBoardEducationDetailsDto> OnBoardEducationDetailsDto,OnBoardReference onBoardReference);
    List<OnBoardEducationDetails> getAll();
}
