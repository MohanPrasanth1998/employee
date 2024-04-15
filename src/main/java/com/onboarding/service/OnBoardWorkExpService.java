package com.onboarding.service;

import java.util.List;

import com.onboarding.dto.OnBoardWorkExperienceDto;
import com.onboarding.model.OnBoardReference;
import com.onboarding.model.OnBoardWorkExperience;

public interface OnBoardWorkExpService {

	boolean saveOnBoardWorkExperience(List<OnBoardWorkExperienceDto> onBoardinWorkExpDto,
			OnBoardReference reference);

	List<OnBoardWorkExperience> getOnBoardWorkExperience();

}
