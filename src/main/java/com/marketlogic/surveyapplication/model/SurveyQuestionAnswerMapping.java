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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "survey_question_answer_mapping")
@NamedQuery(query = "select qam from SurveyQuestionAnswerMapping qam", name = "query_find_all_survey_question_answer")
public class SurveyQuestionAnswerMapping implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public SurveyQuestionAnswerMapping() {

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
	
	@JsonIgnore
	@Column(name = "active", nullable = false)
	private Boolean active;
	
	@Column(name = "created_by")
	private String createdBy;
	
	@Column(name = "updated_by")
	private String updatedBy;
		
	@Column(name = "created_at")
	private Timestamp createdAt;

	@Column(name = "updated_at")
	private Timestamp updatedAt;
	

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

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
	
}
