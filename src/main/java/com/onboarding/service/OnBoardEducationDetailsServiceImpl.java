 package com.onboarding.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onboarding.dao.OnBoardEducationDetailsRepoImpl;
import com.onboarding.dto.OnBoardEducationDetailsDto;
import com.onboarding.exception.CustomRunTimeException;
import com.onboarding.exception.RecordNotFoundException;
import com.onboarding.model.OnBoardEducationDetails;
import com.onboarding.model.OnBoardReference;
import com.onboarding.util.ExceptionMessageUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OnBoardEducationDetailsServiceImpl implements OnBoardEducationDetailsService {

	@Autowired
	private OnBoardEducationDetailsRepoImpl onBoardEducationDetailsRepoImpl;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public boolean saveOnBoardEducationDetails(List<OnBoardEducationDetailsDto> OnBoardEducationDetailsDto,
			OnBoardReference onBoardReference) {
		try {
			//list of details change into model class 
			List<OnBoardEducationDetails> listOnBoardingEducation = OnBoardEducationDetailsDto.stream()
					.map(educationDto -> modelMapper.map(educationDto, OnBoardEducationDetails.class))
					.collect(Collectors.toList());
			//list of class iterate with one object
			listOnBoardingEducation.stream().forEach(educationModel -> {
				educationModel.setOnBoardingReference(onBoardReference);
				onBoardEducationDetailsRepoImpl.save(educationModel);
				if (onBoardReference == null) {
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
	public List<OnBoardEducationDetails> getAll() {

		return onBoardEducationDetailsRepoImpl.findAll();
	}
}
