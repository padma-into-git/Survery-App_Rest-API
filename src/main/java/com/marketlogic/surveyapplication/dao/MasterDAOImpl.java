package com.marketlogic.surveyapplication.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.marketlogic.surveyapplication.model.SurveyAnswerMaster;
import com.marketlogic.surveyapplication.model.SurveyMaster;
import com.marketlogic.surveyapplication.model.SurveyQuestionAnswerMapping;
import com.marketlogic.surveyapplication.model.SurveyQuestionMaster;

@Repository
@Transactional
public class MasterDAOImpl extends BaseDAO implements MasterDAO {

	@Override
	public SurveyMaster createSurvey(SurveyMaster surveyMaster) {
		nativeQuery("SHOW TABLES");
        nativeQuery("SHOW COLUMNS from survey_master");
		persistEntity(surveyMaster);
		return surveyMaster;
	}

	@Override
	public SurveyQuestionMaster saveQuestion(SurveyQuestionMaster questionMaster) {
		nativeQuery("SHOW TABLES");
        nativeQuery("SHOW COLUMNS from survey_question_master");
        if(questionMaster.getId() != 0) {
        	mergeEntity(questionMaster);
        } else  {
		persistEntity(questionMaster);
        }
		return questionMaster;
	}

	@Override
	public List<SurveyQuestionMaster> getQuestion(SurveyQuestionMaster questionMaster) {
		
		if(null == questionMaster) {
			return findAll(SurveyQuestionMaster.class);
			
		} else {
			  EntityManager em = emf.createEntityManager();
			  CriteriaBuilder cb = em.getCriteriaBuilder();
			  CriteriaQuery<SurveyQuestionMaster> cq = cb.createQuery(SurveyQuestionMaster.class);
			  Root<SurveyQuestionMaster> rootEntry = cq.from(SurveyQuestionMaster.class);
			  cq.where(cb.and());
			 
			  if(questionMaster.getId() != 0) {
				  cq.where(cb.and(cb.equal(rootEntry.get("id"),questionMaster.getId())));
			  }
			  
		      TypedQuery<SurveyQuestionMaster> q = em.createQuery(cq); 
		      return q.getResultList();
		} 
		
	}


	@Override
	public SurveyAnswerMaster saveAnswer(SurveyAnswerMaster answerMaster) {
		nativeQuery("SHOW TABLES");
        nativeQuery("SHOW COLUMNS from survey_answer_master");
        if(answerMaster.getId() != 0) {
        	mergeEntity(answerMaster);
        } else  {
        	persistEntity(answerMaster);
        }
		return answerMaster;
	}

	@Override
	public List<SurveyAnswerMaster> getAnswer(SurveyAnswerMaster answerMaster) {
		if(null == answerMaster) {
			return findAll(SurveyAnswerMaster.class);
		} else {
			 EntityManager em = emf.createEntityManager();
			  CriteriaBuilder cb = em.getCriteriaBuilder();
			  CriteriaQuery<SurveyAnswerMaster> cq = cb.createQuery(SurveyAnswerMaster.class);
			  Root<SurveyAnswerMaster> rootEntry = cq.from(SurveyAnswerMaster.class);
			  cq.where(cb.and());
			 
			  if(answerMaster.getId() != 0) {
				  cq.where(cb.and(cb.equal(rootEntry.get("id"),answerMaster.getId())));
			  }
			  
		      TypedQuery<SurveyAnswerMaster> q = em.createQuery(cq); 
		      return q.getResultList();
		}
		
	}

	@Override
	public SurveyQuestionAnswerMapping saveQuestionAnswer(SurveyQuestionAnswerMapping mapping) {
		if(mapping.getSurveyMaster() != null && mapping.getSurveyMaster().getId() != 0) {
			mapping.setSurveyMaster(findById(SurveyMaster.class, mapping.getSurveyMaster().getId()));
		}
		if(mapping.getSurveyQuestionMaster() != null && mapping.getSurveyQuestionMaster().getId() != 0) {
			mapping.setSurveyQuestionMaster(findById(SurveyQuestionMaster.class, mapping.getSurveyQuestionMaster().getId()));
		}
		if(mapping.getSurveyAnswerMaster() != null && mapping.getSurveyAnswerMaster().getId() != 0) {
			mapping.setSurveyAnswerMaster(findById(SurveyAnswerMaster.class, mapping.getSurveyAnswerMaster().getId()));
		}
		nativeQuery("SHOW TABLES");
        nativeQuery("SHOW COLUMNS from survey_question_answer_mapping");
        if(mapping.getId() != 0) {
        	mergeEntity(mapping);
        } else  {
        	persistEntity(mapping);
        }
		return mapping;
	}

	@Override
	public List<SurveyQuestionAnswerMapping> getQuestionAnswerMapping(SurveyQuestionAnswerMapping mapping) {
		if(null == mapping) {
			return findAll(SurveyQuestionAnswerMapping.class);
		} else {
			EntityManager em = emf.createEntityManager();
			  CriteriaBuilder cb = em.getCriteriaBuilder();
			  CriteriaQuery<SurveyQuestionAnswerMapping> cq = cb.createQuery(SurveyQuestionAnswerMapping.class);
			  Root<SurveyQuestionAnswerMapping> rootEntry = cq.from(SurveyQuestionAnswerMapping.class);
			  cq.where(cb.and());
			 
			  if(mapping.getId() != 0) {
				  cq.where(cb.and(cb.equal(rootEntry.get("id"),mapping.getId())));
			  }
			  if(mapping.getSurveyMaster() != null && mapping.getSurveyMaster().getId() != 0) {
				  cq.where(cb.and(cb.equal(rootEntry.get("surveyMaster.id"),mapping.getSurveyMaster().getId())));
			  }
			  if(mapping.getSurveyQuestionMaster() != null && mapping.getSurveyQuestionMaster().getId() != 0) {
				  cq.where(cb.and(cb.equal(rootEntry.get("surveyQuestionMaster.id"),mapping.getSurveyQuestionMaster().getId())));
			  }
			  if(mapping.getSurveyAnswerMaster() != null && mapping.getSurveyAnswerMaster().getId() != 0) {
				  cq.where(cb.and(cb.equal(rootEntry.get("surveyAnswerMaster.id"),mapping.getSurveyAnswerMaster().getId())));
			  }
			  
		      TypedQuery<SurveyQuestionAnswerMapping> q = em.createQuery(cq); 
		      return q.getResultList();
		}
		
	}

}
