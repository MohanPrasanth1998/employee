package com.onboarding.service;

import java.util.List;

import com.onboarding.dto.OnBoardReferenceDto;
import com.onboarding.model.OnBoardReference;



public interface OnBoardReferenceService {
	OnBoardReference saveOnBoardingInfo(OnBoardReferenceDto onBoardReferenceDto);
	List<OnBoardReference> getOnBoardingReference();
	OnBoardReference getOnBoardingReference(String userEmail);
	

}
