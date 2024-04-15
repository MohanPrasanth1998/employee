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

import com.onboarding.dto.OnBoardReferenceDto;
import com.onboarding.model.OnBoardReference;
import com.onboarding.response.Response;
import com.onboarding.service.OnBoardReferenceService;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/service/onboard/reference")
@RestController
@Slf4j
public class OnBoardReferenceController {
	
	@Autowired
	private OnBoardReferenceService onBoardReferenceService;
	
	@GetMapping("/gett")
	public String saveOnBoardingInfo() {
		return "Onboarding running";
	}
	
	@PostMapping("/save")
	//@ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, paramType = "header", dataType = "string", example = "Bearer access_token")
	//@ApiOperation(notes = "This api Save the OnBoardingDetails", value = "Save OnBoard RefernceInfo")
	public Response saveOnBoardingInfo(@RequestBody OnBoardReferenceDto onBoardReferenceDto) {
		 OnBoardReference onBoardRef = onBoardReferenceService.saveOnBoardingInfo(onBoardReferenceDto);
		if (onBoardRef != null) {
			return new Response(onBoardRef.getRefId(), new Date(), "Success", HttpStatus.ACCEPTED);
		}
		return new Response( new Date(), "Failed", HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/get")
	//@ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, paramType = "header", dataType = "string", example = "Bearer access_token")
	//@ApiOperation(notes = "This api Save the OnBoardingDetails", value = "Save OnBoard RefernceInfo")
	public List<OnBoardReference> getOnBoardingReference() {
		log.info("OnBoardingDetails");
		return onBoardReferenceService.getOnBoardingReference();

	}

}
