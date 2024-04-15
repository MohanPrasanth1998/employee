package com.onboarding.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ResponseHandlerUtil {
	
	private static final String MSG="message";
	private static final String TIME_STAMP="timeStamp";
	private static final String STATUS="status";
	private static final String ACCESS_CODE="refId";
	 
	public static ResponseEntity<Map<String, Object>> generateResponse(String message,HttpStatus status){
		Map<String,Object> responseMap=new HashMap<>();
		responseMap.put(TIME_STAMP, new Date());
		responseMap.put(MSG, message);
		responseMap.put(STATUS, status);
		return new ResponseEntity<> (responseMap,HttpStatus.OK);
	}
	
	public static ResponseEntity<Map<String, Object>> generateResponse(String accessCode,String message,HttpStatus status){
		Map<String,Object> responseMap=new HashMap<>();
		responseMap.put(TIME_STAMP, new Date());
		responseMap.put(ACCESS_CODE,accessCode);
		responseMap.put(MSG, message);
		responseMap.put(STATUS, status);
		return new ResponseEntity<> (responseMap,HttpStatus.OK);
	}

}
