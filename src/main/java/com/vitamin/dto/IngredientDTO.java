package com.vitamin.dto;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

import com.vitamin.entity.Category;

public class IngredientDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;	
	private String ingredientName;
	private String description;
	private String details;
	private Double price;
	private String imageURL;
	private String recommendedDosage;
	private String brand;
	private Integer ingredientRank;
	private Category category;
	
	public String getIngredientName() {
		return ingredientName;
	}

	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public String getRecommendedDosage() {
		return recommendedDosage;
	}

	public void setRecommendedDosage(String recommendedDosage) {
		this.recommendedDosage = recommendedDosage;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Integer getIngredientRank() {
		return ingredientRank;
	}

	public void setIngredientRank(Integer ingredientRank) {
		this.ingredientRank = ingredientRank;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
