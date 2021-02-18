package com.marketlogic.surveyapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marketlogic.surveyapplication.model.SurveyAnswerMaster;
import com.marketlogic.surveyapplication.model.SurveyMaster;
import com.marketlogic.surveyapplication.model.SurveyQuestionAnswerMapping;
import com.marketlogic.surveyapplication.model.SurveyQuestionMaster;
import com.marketlogic.surveyapplication.service.MasterService;

@RestController
@RequestMapping("/master")	
public class MasterController {
	
	//Master Controller  has service end points for master data management like survey, questions, answers and their mappings
	
	@Autowired
	MasterService masterService;
	
	@PostMapping("/createSurvey")
	public SurveyMaster createSurvey (@RequestBody SurveyMaster surveyMaster) {
		//master/createSurvey - To create a new survey with Topic has description
		return masterService.createSurvey(surveyMaster);
	}
	@PostMapping("/saveQuestion")
	public SurveyQuestionMaster saveQuestion (@RequestBody SurveyQuestionMaster questionMaster) {
		//master/saveQuestion - To create or edit master list of questions.
		return masterService.saveQuestion(questionMaster);
	}
	@PostMapping("/getQuestion")
	public List<SurveyQuestionMaster> getQuestion (@RequestBody SurveyQuestionMaster questionMaster) {
		//master/getQuestion - To list the Question in a Survey
		return masterService.getQuestion(questionMaster);
	}
	@PostMapping("/deleteQuestion")
	public SurveyQuestionMaster deleteQuestion (@RequestBody SurveyQuestionMaster questionMaster) {
		//master/deleteQuestion - To delete a question from master list
		return masterService.deleteQuestion(questionMaster);
	}
	@PostMapping("/saveAnswer")
	public SurveyAnswerMaster saveAnswer (@RequestBody SurveyAnswerMaster answerMaster) {
		//master/saveAnswer - To create or edit master list of answer options.
		return masterService.saveAnswer(answerMaster);
	}
	
	@PostMapping("/getAnswer")
	public List<SurveyAnswerMaster> getAnswer (@RequestBody SurveyAnswerMaster answerMaster) {
		//master/getAnswer - to list the answers from master list
		return masterService.getAnswer(answerMaster);
	}
	@PostMapping("/deleteAnswer")
	public SurveyAnswerMaster deleteAnswer (@RequestBody SurveyAnswerMaster answerMaster) {
		//master/deleteAnswer - To delete a answer from master list
		return masterService.deleteAnswer(answerMaster);
	}
	@PostMapping("/saveQuestionAnswerMapping")
	public SurveyQuestionAnswerMapping saveQuestionAnswer (@RequestBody SurveyQuestionAnswerMapping mapping) {
		//master/saveQuestionAnswerMapping- To map a question and answer options for a survey.
		return masterService.saveQuestionAnswer(mapping);
	}
	@PostMapping("/getQuestionAnswerMapping")
	public List<SurveyQuestionAnswerMapping> getQuestionAnswerMapping (@RequestBody SurveyQuestionAnswerMapping mapping) {
		//master/getQuestionAnswerMapping - to list the Questions & its Answers in a Survey
		return masterService.getQuestionAnswerMapping(mapping);
	}
	@PostMapping("/deleteQuestionAnswerMapping")
	public SurveyQuestionAnswerMapping deleteQuestionAnswer (@RequestBody SurveyQuestionAnswerMapping mapping) {
		//master/deleteQuestionAnswerMapping - to detach a question or answer mapping for a survey.
		return masterService.deleteQuestionAnswer(mapping);
	}

}
