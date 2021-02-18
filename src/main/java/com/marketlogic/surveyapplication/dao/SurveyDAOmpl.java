package com.marketlogic.surveyapplication.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.marketlogic.surveyapplication.model.SurveyMaster;
import com.marketlogic.surveyapplication.model.SurveyQuestionAnswerMapping;
import com.marketlogic.surveyapplication.model.SurveyQuestionMaster;
import com.marketlogic.surveyapplication.model.SurveyResponse;

@Repository
@Transactional
public class SurveyDAOmpl extends BaseDAO implements SurveyDAO{

	@Override
	public SurveyResponse saveSurveyResponse(SurveyResponse surveyResponse) {
		nativeQuery("SHOW TABLES");
        nativeQuery("SHOW COLUMNS from survey_response");
		persistEntity(surveyResponse);
		return surveyResponse;
	}

	@Override
	public List<SurveyQuestionMaster> fetchQuestionsBySurvey(SurveyMaster surveyMaster) {
		if(null != surveyMaster) {
			EntityManager em = emf.createEntityManager();
			Query query = em.createQuery("select model from SurveyQuestionMaster model join SurveyQuestionAnswerMapping map where  map.surveyMaster.id =1? ");
			query.setParameter(1, surveyMaster.getId());
			List<SurveyQuestionMaster> list = query.getResultList();
			return list;
		}
		return null;
	}

	@Override
	public List<SurveyQuestionAnswerMapping> fetchQuestionsAnswersMappingByQuestion(SurveyQuestionMaster surveyQuestionMaster) {
		if(null != surveyQuestionMaster) {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("select model from SurveyQuestionAnswerMapping model where model.surveyQuestionMaster.id =1? ");
		query.setParameter(1, surveyQuestionMaster.getId());
		List<SurveyQuestionAnswerMapping> list = query.getResultList();
		return list;
		}
		return null;
	}

	@Override
	public List<SurveyQuestionAnswerMapping> fetchQuestionsAnswersMappingBySurvey(SurveyMaster surveyMaster) {
		if(null != surveyMaster) {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("select model from SurveyQuestionAnswerMapping model where model.surveyMaster.id =1? ");
		query.setParameter(1, surveyMaster.getId());
		List<SurveyQuestionAnswerMapping> list = query.getResultList();
		return list;
		}
		return null;
	}

	@Override
	public List<SurveyResponse> fetchSurveyResponseBySurvey(SurveyMaster surveyMaster) {
		if(null != surveyMaster) {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("select model from SurveyResponse model where model.surveyMaster.id =1? ");
		query.setParameter(1, surveyMaster.getId());
		List<SurveyResponse> list = query.getResultList();
		return list;
		}
		return null;
	}

	@Override
	public List<SurveyResponse> fetchSurveyResponseByQuestion(SurveyQuestionAnswerMapping surveyQuestionAnswerMapping) {
		if(null != surveyQuestionAnswerMapping && null != surveyQuestionAnswerMapping.getSurveyMaster() && null != surveyQuestionAnswerMapping.getSurveyQuestionMaster()) {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("select model from SurveyResponse model where model.surveyMaster.id =1? and model.surveyQuestionMaster.id=2?");
		query.setParameter(1, surveyQuestionAnswerMapping.getSurveyMaster().getId());
		query.setParameter(2, surveyQuestionAnswerMapping.getSurveyQuestionMaster().getId());
		List<SurveyResponse> list = query.getResultList();
		return list;
		}
		return null;
	}

}
