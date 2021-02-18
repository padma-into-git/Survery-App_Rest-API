package com.marketlogic.surveyapplication.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketlogic.surveyapplication.dao.MasterDAO;
import com.marketlogic.surveyapplication.model.SurveyAnswerMaster;
import com.marketlogic.surveyapplication.model.SurveyMaster;
import com.marketlogic.surveyapplication.model.SurveyQuestionAnswerMapping;
import com.marketlogic.surveyapplication.model.SurveyQuestionMaster;

@Service
public class MasterServiceImpl implements MasterService {

	@Autowired
	MasterDAO masterDAO;
	@Override
	public SurveyMaster createSurvey(SurveyMaster surveyMaster) {
		if(null != surveyMaster) {
			surveyMaster.setActive(true);
			return masterDAO.createSurvey(surveyMaster);
		}
		return null;
	}

	@Override
	public SurveyQuestionMaster saveQuestion(SurveyQuestionMaster questionMaster) {
		if(null != questionMaster) {
			questionMaster.setActive(true);
			return masterDAO.saveQuestion(questionMaster);
		}
		return null;
	}

	@Override
	public List<SurveyQuestionMaster> getQuestion(SurveyQuestionMaster questionMaster) {
				List <SurveyQuestionMaster> returnList = masterDAO.getQuestion(questionMaster);
				if(null != returnList && !returnList.isEmpty()) {
					return returnList.stream().filter(obj ->obj.getActive()).collect(Collectors.toList());
				}
				return null;
	}

	@Override
	public SurveyAnswerMaster saveAnswer(SurveyAnswerMaster answerMaster) {
		if(null != answerMaster) {
			answerMaster.setActive(true);
			return masterDAO.saveAnswer(answerMaster);
		}
		return null;
	}

	@Override
	public List<SurveyAnswerMaster> getAnswer(SurveyAnswerMaster answerMaster) {
				List <SurveyAnswerMaster> returnList = masterDAO.getAnswer(answerMaster);
				if(null != returnList && !returnList.isEmpty()) {
					return returnList.stream().filter(obj ->obj.getActive()).collect(Collectors.toList());
				}
			return null;
	}

	@Override
	public SurveyQuestionAnswerMapping saveQuestionAnswer(SurveyQuestionAnswerMapping mapping) {
		if(null != mapping) {
			mapping.setActive(true);
			return masterDAO.saveQuestionAnswer(mapping);
		}
		return null;
	}

	@Override
	public List<SurveyQuestionAnswerMapping> getQuestionAnswerMapping(SurveyQuestionAnswerMapping mapping) {
		List <SurveyQuestionAnswerMapping> returnList = masterDAO.getQuestionAnswerMapping(mapping);
		if(null != returnList && !returnList.isEmpty()) {
			return returnList.stream().filter(obj ->obj.getActive()).collect(Collectors.toList());
		}
		return null;
	}

	@Override
	public SurveyQuestionMaster deleteQuestion(SurveyQuestionMaster questionMaster) {
		if(null != questionMaster && questionMaster.getId() != 0) {
			questionMaster.setActive(false);
			return masterDAO.saveQuestion(questionMaster);
		}
		return null;
	}

	@Override
	public SurveyAnswerMaster deleteAnswer(SurveyAnswerMaster answerMaster) {
		if(null != answerMaster && answerMaster.getId() != 0 ) {
			answerMaster.setActive(false);
			return masterDAO.saveAnswer(answerMaster);
		}
		return null;
	}

	@Override
	public SurveyQuestionAnswerMapping deleteQuestionAnswer(SurveyQuestionAnswerMapping mapping) {
		if(null != mapping && mapping.getId() != 0 ) {
			mapping.setActive(false);
			return masterDAO.saveQuestionAnswer(mapping);
		}
		return null;
	}

}
