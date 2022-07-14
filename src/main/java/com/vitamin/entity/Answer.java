package com.vitamin.entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "Answer")
public class Answer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="answer_id_generator")
	@SequenceGenerator(name="answer_id_generator", sequenceName="answer_id_sequence", initialValue=1, allocationSize=1)
	@Column(name="id")
	Integer id;
	
	@Column(name = "answer_name")
	private String answerName;
	
	@Column(name = "image_url")
	private String imageURL;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "question_id")
	@JsonIgnore
	private Question question;
	
	@ManyToMany(mappedBy="answers")
	private Collection<Category> categories;
	
	@ManyToMany(mappedBy="answers")
	private Set<Ingredient> ingredients = new HashSet<>();
	
	
	public Answer() {
		super();
	}

	public Answer(Integer id, String answerName, Question question) {
		super();
		this.id = id;
		this.answerName = answerName;
		this.question = question;
	}

	public Answer(String answerName, Question question) {
		super();
		this.answerName = answerName;
		this.question = question;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAnswerName() {
		return answerName;
	}

	public void setAnswerName(String answerName) {
		this.answerName = answerName;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Collection<Category> getCategories() {
		return categories;
	}

	public void setCategories(Collection<Category> categories) {
		this.categories = categories;
	}

	public Collection<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(Set<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	
}
