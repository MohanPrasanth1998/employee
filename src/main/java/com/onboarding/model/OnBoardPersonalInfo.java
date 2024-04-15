package com.onboarding.model;

import java.util.Date;

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
@Table(name = "on_board_personal_info")
public class OnBoardPersonalInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "middle_name")
	private String middleName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "date_of_birth")
	private Date dateOfBirth;
	@Column(name = "age")
	private int age;
	@Column(name = "gender")
	private String gender;
	@Column(name = "blood_group")
	private String bloodGroup;
	@Column(name = "primary_mail_id")
	private String primaryMailId;
	@Column(name = "alternate_mail_id")
	private String alternateMailId;
	@Column(name = "primary_mobile_no")
	private String primaryMobileNo;
	@Column(name = "alternate_mobile_no")
	private String alternateMobileNo;
	@Column(name = "permanent_address")
	private String permanentAddress;
	@Column(name = "nationality")
	private String nationality;
	@Column(name = "area_pin_code")
	private String areaPinCode;
	@Column(name = "father_name")
	private String fatherName;
	@Column(name = "mother_name")
	private String motherName;
	@Column(name = "marital_status")
	private String maritalStatus;
	@Column(name = "relocate")
	private boolean relocate;
	@Column(name = "reference")
	private String reference;

	@ManyToOne(targetEntity = OnBoardReference.class)
	@JoinColumn(name = "ref_id", referencedColumnName = "ref_id")
	private OnBoardReference refId;
}
