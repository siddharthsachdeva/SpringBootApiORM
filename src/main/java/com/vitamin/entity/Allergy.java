package com.vitamin.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Allergy")
public class Allergy {

	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="answer_id_generator")
	@SequenceGenerator(name="answer_id_generator", sequenceName="answer_id_sequence", initialValue=1, allocationSize=1)
	@Column(name="id")
	Integer id;
	
	private String name;
	
	@ManyToMany(mappedBy="allergies")
	@JsonIgnore
	private Set<Ingredient> ingredients = new HashSet<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(Set<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
}