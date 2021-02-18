package com.marketlogic.surveyapplication.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "survey_response")
@NamedQuery(query = "select r from SurveyResponse r", name = "query_find_all_survey_response")
public class SurveyResponse implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public SurveyResponse() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@JoinColumn(name="survey_id", nullable = false)
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH},targetEntity=SurveyMaster.class)
	private SurveyMaster surveyMaster;
	
	@JoinColumn(name="question_id", nullable = false)
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH},targetEntity=SurveyQuestionMaster.class)
	private SurveyQuestionMaster surveyQuestionMaster;
	
	@JoinColumn(name="answer_id", nullable = false)
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH},targetEntity=SurveyAnswerMaster.class)
	private SurveyAnswerMaster surveyAnswerMaster;
	
	@Column(name = "survey_date")
	private Timestamp surveyDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public SurveyMaster getSurveyMaster() {
		return surveyMaster;
	}

	public void setSurveyMaster(SurveyMaster surveyMaster) {
		this.surveyMaster = surveyMaster;
	}

	public SurveyQuestionMaster getSurveyQuestionMaster() {
		return surveyQuestionMaster;
	}

	public void setSurveyQuestionMaster(SurveyQuestionMaster surveyQuestionMaster) {
		this.surveyQuestionMaster = surveyQuestionMaster;
	}

	public SurveyAnswerMaster getSurveyAnswerMaster() {
		return surveyAnswerMaster;
	}

	public void setSurveyAnswerMaster(SurveyAnswerMaster surveyAnswerMaster) {
		this.surveyAnswerMaster = surveyAnswerMaster;
	}

	public Timestamp getSurveyDate() {
		return surveyDate;
	}

	public void setSurveyDate(Timestamp surveyDate) {
		this.surveyDate = surveyDate;
	}

}
