package com.vitamin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Selected_Answer")
public class SelectedAnswer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="user_answer_id_generator")
	@SequenceGenerator(name="user_answer_id_generator", sequenceName="user_answer_id_sequence", initialValue=1, allocationSize=1)
	@Column(name="id")
	private Integer id;
	
	@Column(name="selected_answer_description")
	private String selectedAnswerDescription;
	
	@Column(name="answer_id")
	private Integer answerId;
	
	@OneToOne
	@JoinColumn(name = "user_answer_id")
	private UserAnswer userAnswer;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSelectedAnswerDescription() {
		return selectedAnswerDescription;
	}

	public void setSelectedAnswerDescription(String selectedAnswerDescription) {
		this.selectedAnswerDescription = selectedAnswerDescription;
	}

	public Integer getAnswerId() {
		return answerId;
	}

	public void setAnswerId(Integer answerId) {
		this.answerId = answerId;
	}

	public UserAnswer getUserAnswer() {
		return userAnswer;
	}

	public void setUserAnswer(UserAnswer userAnswer) {
		this.userAnswer = userAnswer;
	}
	
	

}