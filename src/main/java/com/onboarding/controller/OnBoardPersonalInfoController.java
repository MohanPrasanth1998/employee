 package com.onboarding.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onboarding.dto.OnBoardPersonalInfoDto;
import com.onboarding.model.OnBoardPersonalInfo;
import com.onboarding.model.OnBoardReference;
import com.onboarding.response.Response;
import com.onboarding.service.OnBoardPersonalInfoService;
import com.onboarding.util.ResponseMessageUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/service/onboard/personal/info")
@RestController
public class OnBoardPersonalInfoController { 

	@Autowired
	private OnBoardPersonalInfoService onBoardPersonalInfoService;

	@PostMapping("/save")
	// @ApiImplicitParam(name = "Authorization", value = "Access Token", required =
	// true, paramType = "header", dataType = "string", example = "Bearer
	// access_token")
	// @ApiOperation(notes = "This Api Used for add onboard Personal Information
	// details", value = "This Api Used for add onboard Personal Information
	// details")
	public Response saveOnUpdateOnBoardPersonalInfo(@RequestBody OnBoardPersonalInfoDto onBoardPersonalInfoDto,
			OnBoardReference onBoardReference) throws Exception {
		log.debug("saveOnboardPersonalInformation");
		
			OnBoardPersonalInfo onBoardPersonalInfo = onBoardPersonalInfoService
					.saveOrUpdateOnBoardPersonalInfo(onBoardPersonalInfoDto, onBoardReference);
			if (onBoardPersonalInfo != null)
				return new Response(new Date(), ResponseMessageUtil.SUCCESS, HttpStatus.OK);
		

		return new Response(new Date(), ResponseMessageUtil.FAILED, HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/get/all")
	// @ApiImplicitParam(name = "Authorization", value = "Access Token", required =
	// true, paramType = "header", dataType = "string", example = "Bearer
	// access_token")
	// @ApiOperation(notes = "This Api Used for get all onboard Personal Information
	// details", value = "This Api Used for get all onboard Personal Information
	// details")
	List<OnBoardPersonalInfoDto> getAllOnBoardPersonalInfoDto() {
		
		return onBoardPersonalInfoService.getAllOnBoardPersonalInfoDto();

	}

}
