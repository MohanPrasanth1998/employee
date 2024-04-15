package com.onboarding.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onboarding.dao.OnBoardPersonalInfoDao;
import com.onboarding.dto.OnBoardPersonalInfoDto;
import com.onboarding.exception.CustomRunTimeException;
import com.onboarding.model.OnBoardPersonalInfo;
import com.onboarding.model.OnBoardReference;
import com.onboarding.util.ExceptionMessageUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OnBoardPersonalInfoServiceImpl implements OnBoardPersonalInfoService {

	@Autowired
	private OnBoardPersonalInfoDao onBoardPersonalInfoDao;
	
	@Autowired
	private OnBoardReferenceService onBoardReferenceService;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public OnBoardPersonalInfo saveOrUpdateOnBoardPersonalInfo(OnBoardPersonalInfoDto onBoardPersonalInfoDto,
			OnBoardReference onBoardReference) throws Exception {

		log.debug("Save On Board Personal Information");
		try {
			
			OnBoardReference onBoardReferenceTemp  = onBoardReferenceService.getOnBoardingReference(onBoardPersonalInfoDto.getPrimaryMailId());
		
			OnBoardPersonalInfo onboardPersonalInfo = modelMapper.map(onBoardPersonalInfoDto,
					OnBoardPersonalInfo.class);
			onboardPersonalInfo.setRefId(onBoardReferenceTemp);
			return  onBoardPersonalInfoDao.save(onboardPersonalInfo);
			
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new CustomRunTimeException(ExceptionMessageUtil.PROFILE_SAVE_OR_UPDATE_FAILED);
		}

	}

	@Override
	public List<OnBoardPersonalInfoDto> getAllOnBoardPersonalInfoDto() {

		try {

			onBoardPersonalInfoDao.findAll();

			return new ArrayList<>();

		} catch (Exception e) {
			log.error(e.getMessage());

			return new ArrayList<>();

		}

	}
}
