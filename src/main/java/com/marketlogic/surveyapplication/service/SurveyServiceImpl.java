package com.marketlogic.surveyapplication.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketlogic.surveyapplication.dao.SurveyDAO;
import com.marketlogic.surveyapplication.model.SurveyMaster;
import com.marketlogic.surveyapplication.model.SurveyQuestionAnswerMapping;
import com.marketlogic.surveyapplication.model.SurveyQuestionMaster;
import com.marketlogic.surveyapplication.model.SurveyResponse;

@Service
public class SurveyServiceImpl implements SurveyService {
	
	@Autowired
	SurveyDAO surveyDAO;

	@Override
	public SurveyResponse saveSurveyResponse(SurveyResponse surveyResponse) {
		if(null != surveyResponse) {
			return surveyDAO.saveSurveyResponse(surveyResponse);
		}
		return null;
	}
	

	@Override
	public List<SurveyQuestionMaster> fetchQuestionsBySurvey(SurveyMaster surveyMaster) {
		if(surveyMaster != null) {
			List <SurveyQuestionMaster> returnList = surveyDAO.fetchQuestionsBySurvey(surveyMaster);
			if(null != returnList && !returnList.isEmpty()) {
				return returnList.stream().filter(obj ->obj.getActive()).collect(Collectors.toList());
			}
		}
		return null;
	}

	@Override
	public List<SurveyQuestionAnswerMapping> fetchQuestionsAnswersMappingByQuestion(SurveyQuestionMaster surveyQuestionMaster) {
		if(surveyQuestionMaster != null) {
			List <SurveyQuestionAnswerMapping> returnList = surveyDAO.fetchQuestionsAnswersMappingByQuestion(surveyQuestionMaster);
			if(null != returnList && !returnList.isEmpty()) {
				return returnList.stream().filter(obj ->obj.getActive()).collect(Collectors.toList());
			}
		}
		return null;
	}

	@Override
	public List<SurveyQuestionAnswerMapping> fetchQuestionsAnswersMappingBySurvey(SurveyMaster surveyMaster) {
		if(surveyMaster != null) {
			List <SurveyQuestionAnswerMapping> returnList = surveyDAO.fetchQuestionsAnswersMappingBySurvey(surveyMaster);
			if(null != returnList && !returnList.isEmpty()) {
				return returnList.stream().filter(obj ->obj.getActive()).collect(Collectors.toList());
			}
		}
		return null;
	}

	@Override
	public List<SurveyResponse> fetchSurveyResponseBySurvey(SurveyMaster surveyMaster) {
		if(surveyMaster != null) {
			return surveyDAO.fetchSurveyResponseBySurvey(surveyMaster);
		}
		return null;
	}

	@Override
	public List<SurveyResponse> fetchSurveyResponseByQuestion(SurveyQuestionAnswerMapping surveyQuestionAnswerMapping) {
		if(surveyQuestionAnswerMapping != null) {
			return surveyDAO.fetchSurveyResponseByQuestion(surveyQuestionAnswerMapping);
		}
		return null;
	}

}
