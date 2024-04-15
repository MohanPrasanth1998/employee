package com.onboarding.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorMessage {

	private Date date;
	private String message;
	private String details;
	private HttpStatus status;

	public ErrorMessage(Date date, String message, String details, HttpStatus status) {
		super();
		this.date = date;
		this.message = message;
		this.details = details;
		this.status = status;
	}

}
