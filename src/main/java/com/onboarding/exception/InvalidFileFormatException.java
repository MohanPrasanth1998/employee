package com.onboarding.exception;

public class InvalidFileFormatException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public InvalidFileFormatException(String exception) {
		super(exception);
	}
}
