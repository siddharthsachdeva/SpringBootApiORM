package com.vitamin.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Next_Question")
public class NextQuestion {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="next_question_id_generator")
	@SequenceGenerator(name="next_question_id_generator", sequenceName="next_question_id_sequence", initialValue=1, allocationSize=1)
	@Column(name="id")
	Integer id;
	
	@Column(name="condition")
	private String condition;
	
	@Column(name="value")
	private Integer value;
	
	@Column(name="next_question_id")
	private Integer nextQuestionId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "question_id")
	@JsonIgnore
	private Question question;

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Integer getNextQuestionId() {
		return nextQuestionId;
	}

	public void setNextQuestionId(Integer nextQuestionId) {
		this.nextQuestionId = nextQuestionId;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
	
}
