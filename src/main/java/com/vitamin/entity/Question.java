package com.vitamin.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Question")
public class Question {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="question_id_generator")
	@SequenceGenerator(name="question_id_generator", sequenceName="question_id_sequence", initialValue=1, allocationSize=1)
	@Column(name="id")
	Integer id;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "instruction")
	private String instruction;
	
	@OneToMany(mappedBy="question", cascade=CascadeType.ALL)
	private Collection<NextQuestion> nextQuestion = new ArrayList<>();
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "validation")
	private String validation;
	
	@Column(name = "error")
	private String error;
	
	@OneToMany(mappedBy="question", cascade=CascadeType.ALL)
	private Collection<Answer> answers = new ArrayList<Answer>();

	public Question() {
		super();
	}

	public Question(Integer id, String description, Collection<NextQuestion> nextQuestion, Collection<Answer> answers, String type) {
		super();
		this.id = id;
		this.description = description;
		this.nextQuestion = nextQuestion;
		this.answers = answers;
		this.type = type;
	}

	public Question(String description, Collection<NextQuestion> nextQuestion, Collection<Answer> answers, String type) {
		super();
		this.description = description;
		this.nextQuestion = nextQuestion;
		this.answers = answers;
		this.type = type;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Collection<NextQuestion> getNextQuestion() {
		return nextQuestion;
	}

	public void setNextQuestion(Collection<NextQuestion> nextQuestion) {
		this.nextQuestion = nextQuestion;
	}

	public Collection<Answer> getAnswers() {
		return answers;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setAnswers(Collection<Answer> answers) {
		this.answers = answers;
	}

	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	public String getValidation() {
		return validation;
	}

	public void setValidation(String validation) {
		this.validation = validation;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
}
