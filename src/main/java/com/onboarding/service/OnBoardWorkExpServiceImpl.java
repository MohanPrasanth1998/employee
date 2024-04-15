package com.onboarding.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onboarding.dao.OnBoardWorkExperienceRepoImpl;
import com.onboarding.dto.OnBoardWorkExperienceDto;
import com.onboarding.exception.CustomRunTimeException;
import com.onboarding.exception.RecordNotFoundException;
import com.onboarding.model.OnBoardReference;
import com.onboarding.model.OnBoardWorkExperience;
import com.onboarding.util.ExceptionMessageUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OnBoardWorkExpServiceImpl implements OnBoardWorkExpService {

	@Autowired
	private OnBoardWorkExperienceRepoImpl onBoardWorkExperienceRepoImpl;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public boolean saveOnBoardWorkExperience(List<OnBoardWorkExperienceDto> onBoardWorkExpDto,
			OnBoardReference reference) {
		try {
			List<OnBoardWorkExperience> listOnBoardingWorkExperience = onBoardWorkExpDto.stream().map(experienceDto -> {

				return modelMapper.map(experienceDto, OnBoardWorkExperience.class);
			}).collect(Collectors.toList());
			listOnBoardingWorkExperience.stream().forEach(experienceModel -> {
				experienceModel.setOnBoardingReference(reference);
				onBoardWorkExperienceRepoImpl.save(experienceModel);
				if (reference == null) {
					throw new RecordNotFoundException(ExceptionMessageUtil.INVALID_REFERENCE);
				}

			});
			return true;

		} catch (Exception e) {
			log.error(e.getMessage());
			if (e instanceof RecordNotFoundException) {
				throw new RecordNotFoundException(e.getMessage());
			}
			throw new CustomRunTimeException(ExceptionMessageUtil.Unable_TO_LOAD_THE_REFERENCE);
		}

	}

	@Override
	public List<OnBoardWorkExperience> getOnBoardWorkExperience() {
	
	return onBoardWorkExperienceRepoImpl.findAll();
	

	}
}