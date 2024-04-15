package com.onboarding.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;




@Getter
@Setter
public class OnBoardAll {
	
	
	private List<OnBoardWorkExperience> listOnBoardWorkExperience ;
	private List<OnBoardEducationDetails> listOnBoardEducationDetails;
	private OnBoardPersonalInfo  onBoardPersonalInfo; 
	public String getemailId;
	
	

}
