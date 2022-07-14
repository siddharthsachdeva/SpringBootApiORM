package com.vitamin.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Recommendation")
public class Recommendation {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="recommendation_id_generator")
	@SequenceGenerator(name="recommendation_id_generator", sequenceName="recommendation_id_sequence", initialValue=1, allocationSize=1)
	@Column(name="id")
	Integer id;
	
	@OneToMany
	  @JoinTable(
	            name="Recommendation_Ingredient",
	            joinColumns = @JoinColumn( name="recommendation_id"),
	            inverseJoinColumns = @JoinColumn( name="ingredient_id")
	    )
	Collection<Ingredient> ingredients;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Collection<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(Collection<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	
}
