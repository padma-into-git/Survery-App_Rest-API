package com.marketlogic.surveyapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marketlogic.surveyapplication.model.SurveyMaster;
import com.marketlogic.surveyapplication.model.SurveyQuestionAnswerMapping;
import com.marketlogic.surveyapplication.model.SurveyQuestionMaster;
import com.marketlogic.surveyapplication.model.SurveyResponse;
import com.marketlogic.surveyapplication.service.SurveyService;

@RestController
@RequestMapping("/survey")	
public class SurveyController {
	
	@Autowired
	SurveyService surveyService;
	
	@PostMapping("/saveSurveyResponse")
	public SurveyResponse saveSurveyResponse (@RequestBody SurveyResponse surveyResponse) {
		//To save the user response to a survey question.
		return surveyService.saveSurveyResponse(surveyResponse);
	}
	@PostMapping("/fetchQuestionsBySurvey")
	public List<SurveyQuestionMaster> fetchQuestionsBySurvey (@RequestBody SurveyMaster surveyMaster) {
		//To fetch the list of questions mapped a survey
		return surveyService.fetchQuestionsBySurvey(surveyMaster);
	}
	@PostMapping("/fetchQuestionsAnswersMappingByQuestion")
	public List<SurveyQuestionAnswerMapping> fetchQuestionsAnswersMappingByQuestion (@RequestBody SurveyQuestionMaster surveyQuestionMaster) {
		//to fetch the answers given by users to a question for a survey.
		return surveyService.fetchQuestionsAnswersMappingByQuestion(surveyQuestionMaster);
	}
	@PostMapping("/fetchQuestionsAnswersMappingBySurvey")
	public List<SurveyQuestionAnswerMapping> fetchQuestionsAnswersMappingBySurvey (@RequestBody SurveyMaster surveyMaster) {
		//to fetch list of questions and respective  answers mapped to a survey.
		return surveyService.fetchQuestionsAnswersMappingBySurvey(surveyMaster);
	}
	@PostMapping("/fetchSurveyResponseBySurvey")
	public List<SurveyResponse> fetchSurveyResponseBySurvey (@RequestBody SurveyMaster surveyMaster) {
		//To get the answer given by  the user on a survey.
		return surveyService.fetchSurveyResponseBySurvey(surveyMaster);
	}
	@PostMapping("/fetchSurveyResponseByQuestion")
	public List<SurveyResponse> fetchSurveyResponseByQuestion (@RequestBody SurveyQuestionAnswerMapping surveyQuestionAnswerMapping) {
		//To get the answer given by  the user for a question on a survey.
		return surveyService.fetchSurveyResponseByQuestion(surveyQuestionAnswerMapping);
	}
}
