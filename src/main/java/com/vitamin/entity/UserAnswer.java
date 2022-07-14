package com.vitamin.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "User_Answer")
public class UserAnswer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="user_answer_id_generator")
	@SequenceGenerator(name="user_answer_id_generator", sequenceName="user_answer_id_sequence", initialValue=1, allocationSize=1)
	@Column(name="id")
	private Integer id;
	
	@Column(name="user_id")
	private Integer userId;
	
	@Column(name="question_description")
	private String questionDescription;
	
	@Column(name="question_id")
	private Integer questionId;
	
	@OneToMany(mappedBy="userAnswer")
	private Collection<SelectedAnswer> selectedAnswers;

	public UserAnswer() {
		super();
	}

	public UserAnswer(Integer id, Integer userId, String questionDescription, String selectedAnswer, Integer questionId,
			Integer answerId) {
		super();
		this.id = id;
		this.userId = userId;
		this.questionDescription = questionDescription;
		this.questionId = questionId;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getQuestionDescription() {
		return questionDescription;
	}

	public void setQuestionDescription(String question) {
		this.questionDescription = question;
	}

	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public Collection<SelectedAnswer> getSelectedAnswers() {
		return selectedAnswers;
	}

	public void setSelectedAnswers(Collection<SelectedAnswer> selectedAnswers) {
		this.selectedAnswers = selectedAnswers;
	}	
	
}