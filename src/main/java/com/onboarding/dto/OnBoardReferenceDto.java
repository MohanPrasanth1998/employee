package com.onboarding.dto;

import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
public class OnBoardReferenceDto {
	
		private String refId ; 
		private String status;
		private String emailId;
		private OnBoardPersonalInfoDto  onboardPersonalInformationDto;
		private List<OnBoardWorkExperienceDto> listOnBoardWorkExperienceDto ;
		private List<OnBoardEducationDetailsDto> listOnBoardEducationDetailsDto;
		
		
	

}
