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
@Table(name = "on_board_work_experience")
public class OnBoardWorkExperience {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(targetEntity = OnBoardReference.class)
	@JoinColumn(name = "ref_id", referencedColumnName = "ref_Id")
	private OnBoardReference onBoardingReference;

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "job_title")
	private String jobTitle;

	@Column(name = "address")
	private String address;

	@Column(name = "joining_date")
	private String joiningDate;

	@Column(name = "ending_date")
	private String endingDate;

	@Column(name = "year_of_experience")
	private int yearOfExperience;

	@Column(name = "current_notice_period")
	private int currentNoticePeriod;

	@Column(name = "current_CTC")
	private String currentCTC;

	@Column(name = "expected_salary")
	private String expectedSalary;

	@Column(name = "referance_mobile_number")
	private long referanceMobileNumber;

	
	@Column(name = "saved_status")
	private boolean savedStatus;

}
