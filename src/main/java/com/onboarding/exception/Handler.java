package com.onboarding.exception;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.Date;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.security.sasl.AuthenticationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;



@ControllerAdvice
@RestControllerAdvice
public class Handler {
	
ErrorMessage errorMessage;
	
	@ExceptionHandler(EntityExistsException.class)
	public ResponseEntity<ErrorMessage>handleEntityExistsException(EntityExistsException exception,WebRequest request){
		 errorMessage=new ErrorMessage(new Date(),exception.getMessage(),request.getDescription(false),HttpStatus.CONFLICT);
		return new ResponseEntity<>(errorMessage,HttpStatus.OK);
	}
	@ExceptionHandler(InvalidParameterException.class)
	public ResponseEntity<ErrorMessage>handleInvalidParameterException(InvalidParameterException exception,WebRequest request){
		errorMessage=new ErrorMessage(new Date(),exception.getMessage(),request.getDescription(false),HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(errorMessage,HttpStatus.OK);
	}
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<ErrorMessage>handleInvalidParameterException(EntityNotFoundException exception,WebRequest request){
		errorMessage=new ErrorMessage(new Date(),exception.getMessage(),request.getDescription(false),HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(errorMessage,HttpStatus.OK);
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage>handleCustomException(Exception exception,WebRequest request){
		errorMessage=new ErrorMessage(new Date(),exception.getMessage(),request.getDescription(false),HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(errorMessage,HttpStatus.OK);
	}
//	@ExceptionHandler(CustomRuntimeException.class)
//	public ResponseEntity<ErrorMessage>handleCustomRuntimeException(CustomRuntimeException exception,WebRequest request){
//		errorMessage=new ErrorMessage(new Date(),exception.getMessage(),request.getDescription(false),HttpStatus.BAD_REQUEST);
//		return new ResponseEntity<>(errorMessage,HttpStatus.OK);
//	}
	@ExceptionHandler(IOException.class)
	public ResponseEntity<ErrorMessage>handleException(IOException exception,WebRequest request){
		 errorMessage=new ErrorMessage(new Date(),exception.getMessage(),request.getDescription(false),HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(errorMessage,HttpStatus.OK);
	}
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<ErrorMessage>handleException(NullPointerException exception,WebRequest request){
		 errorMessage=new ErrorMessage(new Date(),exception.getMessage(),request.getDescription(false),HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(errorMessage,HttpStatus.OK);
	}
	@ExceptionHandler(FileNotFoundException.class)
	public ResponseEntity<ErrorMessage>handleException(FileNotFoundException exception,WebRequest request){
		 errorMessage=new ErrorMessage(new Date(),exception.getMessage(),request.getDescription(false),HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(errorMessage,HttpStatus.OK);
	}
/*	@ExceptionHandler(TokenAuthenticationException.class)
	public ResponseEntity<ErrorMessage>handleException(TokenAuthenticationException exception,WebRequest request){
		 errorMessage=new ErrorMessage(new Date(),exception.getMessage(),request.getDescription(false),HttpStatus.UNAUTHORIZED);
		return new ResponseEntity<>(errorMessage,HttpStatus.UNAUTHORIZED);
	}
	
	@ExceptionHandler(InvalidRequestException.class)
	public ResponseEntity<ErrorMessage>handleException(InvalidRequestException exception,WebRequest request){
		 errorMessage=new ErrorMessage(new Date(),exception.getMessage(),request.getDescription(false),HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(errorMessage,HttpStatus.BAD_REQUEST);
	}*/
	@ExceptionHandler(AuthenticationException.class)
	public ResponseEntity<ErrorMessage>handleException(AuthenticationException exception,WebRequest request){
		 errorMessage=new ErrorMessage(new Date(),exception.getMessage(),request.getDescription(false),HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(errorMessage,HttpStatus.BAD_REQUEST);
	}
	
	
	
	

}
