package com.onboarding.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "on_board_reference")
public class OnBoardReference  {
	
	@Id
	@Column(name = "ref_id",unique = true)
	private String refId;
	@Column(name = "status")
	private String status;
	@Column(name = "user_email")
	private String emailId;
	
	@Override
	public String toString() {
		return "OnBoardReference [refId=" + refId + ", status=" + status + ", emailId=" + emailId + "]";
	}

}
