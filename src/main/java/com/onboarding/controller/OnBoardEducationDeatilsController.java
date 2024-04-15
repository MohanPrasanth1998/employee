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

import com.onboarding.dto.OnBoardEducationDetailsDto;
import com.onboarding.model.OnBoardEducationDetails;
import com.onboarding.model.OnBoardReference;
import com.onboarding.response.Response;
import com.onboarding.service.OnBoardEducationDetailsService;
import com.onboarding.util.ResponseMessageUtil;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/service/onboard/education/info")
@RestController
@Slf4j
public class OnBoardEducationDeatilsController {

	@Autowired
	private OnBoardEducationDetailsService onBoardingEducationService;

	@PostMapping("/save")
	//@ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, paramType = "header", dataType = "string", example = "Bearer access_token")
	//@ApiOperation(notes = "This api Save the OnBoardingDetails", value = "Save OnBoard Details")
	public Response saveOnBoardEducationDetails(
			@RequestBody List<OnBoardEducationDetailsDto> onBoardEducationDetailsDto,
			OnBoardReference onBoardReference) {
		try {
			onBoardingEducationService.saveOnBoardEducationDetails(onBoardEducationDetailsDto, onBoardReference);
			return new Response( new Date(), ResponseMessageUtil.SUCCESS, HttpStatus.ACCEPTED);

		} catch (Exception e) {
			return new Response(new Date(),ResponseMessageUtil.FAILED , HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/get/all")
//	@ApiOperation(notes = "This api Find the OnBoardingDetails", value = "Find OnBoard Details")
	public List<OnBoardEducationDetails> getOnBoardEducationDetails() {
		log.info("OnBoardingEducation");
		return onBoardingEducationService.getAll();
	}
}
