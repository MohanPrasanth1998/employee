package com.onboarding.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onboarding.dao.OnBoardRefernceRepoImpl;
import com.onboarding.dto.OnBoardPersonalInfoDto;
import com.onboarding.dto.OnBoardReferenceDto;
import com.onboarding.exception.CustomRunTimeException;
import com.onboarding.model.OnBoardReference;
import com.onboarding.util.ExceptionMessageUtil;
import com.onboarding.util.RandomGenerationUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OnBoardReferenceServiceImpl implements OnBoardReferenceService {

	@Autowired
	private OnBoardRefernceRepoImpl onBoardRefernceRepoImpl;
	@Autowired
	private OnBoardPersonalInfoService onBoardPersonalInfoService;
	@Autowired
	private OnBoardEducationDetailsService onBoardEducationDetailsService;
	@Autowired
	private OnBoardWorkExpService onBoardWorkExpService;

	@Override
	public OnBoardReference saveOnBoardingInfo(OnBoardReferenceDto onBoardReferenceDto) {
		log.debug(" save OnBoardingdetails");
		OnBoardReference onBoardReference = new OnBoardReference();
		try {
			onBoardReference = generateReferenceInfo(onBoardReferenceDto);
			onBoardPersonalInfoService.saveOrUpdateOnBoardPersonalInfo(
					onBoardReferenceDto.getOnboardPersonalInformationDto(), onBoardReference);
			boolean isSavedEdu = onBoardEducationDetailsService.saveOnBoardEducationDetails(
					onBoardReferenceDto.getListOnBoardEducationDetailsDto(), onBoardReference);
			
			if (!isSavedEdu) {
				throw new CustomRunTimeException(ExceptionMessageUtil.DETAILS_FAILED_TO_SAVE);
			}
			boolean isSavedwrk = onBoardWorkExpService
					.saveOnBoardWorkExperience(onBoardReferenceDto.getListOnBoardWorkExperienceDto(), onBoardReference);
			if (!isSavedwrk) {
				
				throw new CustomRunTimeException(ExceptionMessageUtil.DETAILS_FAILED_TO_SAVE);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new CustomRunTimeException(ExceptionMessageUtil.ONBOARD_INFO_FAILED_TO_SAVE);
		}
		return onBoardReference;

	}

	private OnBoardReference generateReferenceInfo(OnBoardReferenceDto onBoardReferenceDto) {
		log.debug("generateReferenceInfo");
     	try {
     		OnBoardReference onBoardingReference = new OnBoardReference();
     		onBoardingReference.setStatus(onBoardReferenceDto.getStatus());
			onBoardingReference.setRefId(RandomGenerationUtil.generateReferenceCode());
			onBoardingReference.setEmailId(onBoardReferenceDto.getEmailId());
			onBoardingReference = onBoardRefernceRepoImpl.save(onBoardingReference);
			return onBoardingReference;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new CustomRunTimeException(ExceptionMessageUtil.REFERENCE_GENERATION_FAILED);
		}
	}

	private boolean savePersonalDetails(OnBoardPersonalInfoDto onboardPersonalInfoDto,
			OnBoardReference onBoardingReference) {
		try {
			onBoardPersonalInfoService.saveOrUpdateOnBoardPersonalInfo(onboardPersonalInfoDto, onBoardingReference);
			return true;
		} catch (Exception e) {
			log.error(e.getMessage());
			return false;
		}
	}

	@Override
	public List<OnBoardReference> getOnBoardingReference() {

		return onBoardRefernceRepoImpl.findAll();
	}

	@Override
	public OnBoardReference getOnBoardingReference(String userEmail) {

		OnBoardReference onBoardReference = new OnBoardReference();
		
		try {
			onBoardReference = onBoardRefernceRepoImpl.findByEmailId(userEmail);
			if (onBoardReference == null) {
				onBoardReference = new OnBoardReference();
				onBoardReference.setEmailId(userEmail);
				onBoardReference = onBoardRefernceRepoImpl.save(onBoardReference);
			}

		} catch (Exception e) {
			log.error(e.getMessage());

		}

	return onBoardReference;
	}

}
