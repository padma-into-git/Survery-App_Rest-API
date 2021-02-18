package com.marketlogic.surveyapplication.service;

import java.util.List;

import com.marketlogic.surveyapplication.model.SurveyAnswerMaster;
import com.marketlogic.surveyapplication.model.SurveyMaster;
import com.marketlogic.surveyapplication.model.SurveyQuestionAnswerMapping;
import com.marketlogic.surveyapplication.model.SurveyQuestionMaster;

public interface MasterService {

	public SurveyMaster createSurvey(SurveyMaster surveyMaster);

	public SurveyQuestionMaster saveQuestion(SurveyQuestionMaster questionMaster);

	public List<SurveyQuestionMaster> getQuestion(SurveyQuestionMaster questionMaster);

	public SurveyAnswerMaster saveAnswer(SurveyAnswerMaster answerMaster);

	public List<SurveyAnswerMaster> getAnswer(SurveyAnswerMaster answerMaster);

	public SurveyQuestionAnswerMapping saveQuestionAnswer(SurveyQuestionAnswerMapping mapping);

	public List<SurveyQuestionAnswerMapping> getQuestionAnswerMapping(SurveyQuestionAnswerMapping mapping);

	public SurveyQuestionMaster deleteQuestion(SurveyQuestionMaster questionMaster);

	public SurveyAnswerMaster deleteAnswer(SurveyAnswerMaster answerMaster);

	public SurveyQuestionAnswerMapping deleteQuestionAnswer(SurveyQuestionAnswerMapping mapping);

}
