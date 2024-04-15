package com.onboarding.dto;

import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
public class OnBoardPersonalInfoDto {

	private long id;

	private String firstName;

	private String middleName;

	private String lastName;

	private Date dateOfBirth;

	private int age;

	private String gender;

	private String bloodGroup;

	private String primaryMailId;

	private String alternateMailId;

	private String primaryMobileNo;

	private String alternateMobileNo;

	private String permanentAddress;

	private String nationality;

	private String areaPinCode;

	private String fatherName;

	private String motherName;

	private String maritalStatus;

	private boolean relocate;

	private String reference;

}
