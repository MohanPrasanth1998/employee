package com.onboarding.service;

import java.util.List;

import com.onboarding.dto.OnBoardPersonalInfoDto;
import com.onboarding.model.OnBoardPersonalInfo;
import com.onboarding.model.OnBoardReference;

public interface OnBoardPersonalInfoService {

	OnBoardPersonalInfo saveOrUpdateOnBoardPersonalInfo(OnBoardPersonalInfoDto onBoardPersonalInfoDto,OnBoardReference onBoardReference ) throws Exception;

	List<OnBoardPersonalInfoDto> getAllOnBoardPersonalInfoDto();
}
