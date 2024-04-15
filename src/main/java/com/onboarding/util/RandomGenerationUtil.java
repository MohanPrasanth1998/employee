package com.onboarding.util;


import org.apache.commons.lang3.RandomStringUtils;

import com.onboarding.exception.RandomGeneratorException;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@UtilityClass
public class RandomGenerationUtil {
	public static String generateReferenceCode() {
	
		try {
			return "ONB-"+RandomStringUtils.random(3, "0123456789T");	
		}catch(Exception exception) {
			log.error(exception.getMessage() );
			throw new RandomGeneratorException(ExceptionMessageUtil.CANNOT_CREATE_RANDOM_NUMBER);
		}
	}
	
}
