package com.onboarding.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Data
@ToString
public class OnBoardEducationDetailsDto {

	private int id;

	private String instituteName;

	private String board;

	private String university;

	private String areaOfStudy;

	private String graduation;

	private String stream;

	private int yearOfPassOut;

	private int yearOfStart;

	private String cgpa;

	private String percentage;

	private long markSheetNo;

}
