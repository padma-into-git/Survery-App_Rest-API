package com.marketlogic.surveyapplication.dao;

import java.util.List;

import com.marketlogic.surveyapplication.model.SurveyAnswerMaster;
import com.marketlogic.surveyapplication.model.SurveyMaster;
import com.marketlogic.surveyapplication.model.SurveyQuestionAnswerMapping;
import com.marketlogic.surveyapplication.model.SurveyQuestionMaster;

public interface MasterDAO {
	
	public SurveyMaster createSurvey(SurveyMaster surveyMaster);

	public SurveyQuestionMaster saveQuestion(SurveyQuestionMaster questionMaster);

	public List<SurveyQuestionMaster> getQuestion(SurveyQuestionMaster questionMaster);

	public SurveyAnswerMaster saveAnswer(SurveyAnswerMaster answerMaster);

	public List<SurveyAnswerMaster> getAnswer(SurveyAnswerMaster answerMaster);

	public SurveyQuestionAnswerMapping saveQuestionAnswer(SurveyQuestionAnswerMapping mapping);

	public List<SurveyQuestionAnswerMapping> getQuestionAnswerMapping(SurveyQuestionAnswerMapping mapping);

}
