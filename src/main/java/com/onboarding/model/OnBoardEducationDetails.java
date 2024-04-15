package com.onboarding.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "on_board_education_details")
public class OnBoardEducationDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(targetEntity = OnBoardReference.class)
	@JoinColumn(name = "ref_id", referencedColumnName = "ref_Id")
	private OnBoardReference onBoardingReference;

	@Column(name = "institute_name")
	private String instituteName;
	@Column(name = "board")
	private String board;
	@Column(name = "university")
	private String university;
	@Column(name = "area_of_study")
	private String areaOfStudy;
	@Column(name = "graduation")
	private String graduation;
	@Column(name = "stream")
	private String stream;
	@Column(name = "mark_sheet_no")
	private long markSheetNo;
	@Column(name = "cgpa")
	private String cgpa;
	@Column(name = "percentage")
	private String percentage;
	@Column(name = "year_of_start")
	private int yearOfStart;
	@Column(name = "year_of_passout")
	private int yearOfPassOut;

}
