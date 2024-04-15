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
import com.onboarding.dto.OnBoardWorkExperienceDto;
import com.onboarding.model.OnBoardReference;
import com.onboarding.model.OnBoardWorkExperience;
import com.onboarding.response.Response;
import com.onboarding.service.OnBoardWorkExpService;


@RequestMapping("/service/onboard/experience")
@RestController
public class OnBoardWorkExperienceController {

	@Autowired
	private OnBoardWorkExpService onBoardWorkExpService;

	@PostMapping("/save")
	// @ApiImplicitParam(name = "Authorization", value = "Access Token", required =
	// true, paramType = "header", dataType = "string", example = "Bearer
	// access_token")
	// @ApiOperation(notes = "This api Save the OnBoardingWorkExperienceDetails",
	// value = "Save OnBoard WorkExperience ")
	public Response saveOnBoardWorkExperience(@RequestBody List<OnBoardWorkExperienceDto> onBoardWorkExperienceDto,
			OnBoardReference onBoardReference) {
		try {
			onBoardWorkExpService.saveOnBoardWorkExperience(onBoardWorkExperienceDto, onBoardReference);
			return new Response(new Date(), "Success", HttpStatus.ACCEPTED);

		} catch (Exception e) {
			return new Response(new Date(), "Failed", HttpStatus.BAD_REQUEST);

		}
	}

	@GetMapping("/get/all")
	// @ApiImplicitParam(name = "Authorization", value = "Access Token", required =
	// true, paramType = "header", dataType = "string", example = "Bearer
	// access_token")
	// @ApiOperation(notes = "This api Find the OnBoardingDetails", value = "Find
	// OnBoard WorkExperience Details")
	public List<OnBoardWorkExperience> getOnBoardingWorkExperience() {
		return onBoardWorkExpService.getOnBoardWorkExperience();
	}

}
