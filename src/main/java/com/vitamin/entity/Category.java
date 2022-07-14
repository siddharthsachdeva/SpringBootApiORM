package com.vitamin.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Category")
public class Category {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="category_id_generator")
	@SequenceGenerator(name="category_id_generator", sequenceName="category_id_sequence", initialValue=1, allocationSize=1)
	@Column(name="id")
	Integer id;

	@Column(name = "category_name")
	private String categoryName;
	
	@Column(name = "category_rank")
	private Integer categoryRank;
	
	@Column(name = "image_url")
	private String imageURL;
	
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Category_Answer", 
            joinColumns = { @JoinColumn(name = "category_id") }, 
            inverseJoinColumns = { @JoinColumn(name = "answer_id") }
        )
	@JsonIgnore
	private Collection<Answer> answers;
	
	@OneToMany(mappedBy = "category", cascade=CascadeType.ALL)
	@JsonIgnore
	private Collection<Ingredient> ingredients;
	
	
	public Category() {
		super();
	}

	public Category(Integer id, String categoryName, Integer rank) {
		super();
		this.id = id;
		this.categoryName = categoryName;
		this.categoryRank = rank;
	}

	public Category(String categoryName, Integer rank) {
		super();
		this.categoryName = categoryName;
		this.categoryRank = rank;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Integer getCategoryRank() {
		return categoryRank;
	}

	public void setCategoryRank(Integer rank) {
		this.categoryRank = rank;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
}
