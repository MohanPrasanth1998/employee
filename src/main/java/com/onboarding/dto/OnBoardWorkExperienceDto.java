package com.onboarding.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
public class OnBoardWorkExperienceDto {

	private int id;

	private String companyName;

	private String jobTitle;

	private String address;

	private String joiningDate;

	private String endingDate;

	private String yearOfExperience;

	private int currentNoticePeriod;

	private String currentCTC;

	private String referanceMobileNumber;

	private String expectedSalary;

	private boolean savedStatus;
	private String saveType;

}
