package com.marketlogic.surveyapplication.dao;

import java.util.List;

import com.marketlogic.surveyapplication.model.SurveyMaster;
import com.marketlogic.surveyapplication.model.SurveyQuestionAnswerMapping;
import com.marketlogic.surveyapplication.model.SurveyQuestionMaster;
import com.marketlogic.surveyapplication.model.SurveyResponse;


public interface SurveyDAO {
	
	public SurveyResponse saveSurveyResponse(SurveyResponse surveyResponse);

	public List<SurveyQuestionMaster> fetchQuestionsBySurvey(SurveyMaster surveyMaster);

	public List<SurveyQuestionAnswerMapping> fetchQuestionsAnswersMappingByQuestion(SurveyQuestionMaster surveyQuestionMaster);

	public List<SurveyQuestionAnswerMapping> fetchQuestionsAnswersMappingBySurvey(SurveyMaster surveyMaster);

	public List<SurveyResponse> fetchSurveyResponseBySurvey(SurveyMaster surveyMaster);

	public List<SurveyResponse> fetchSurveyResponseByQuestion(SurveyQuestionAnswerMapping surveyQuestionAnswerMapping);

}
