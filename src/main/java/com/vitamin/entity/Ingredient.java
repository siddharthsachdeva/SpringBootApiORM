package com.vitamin.entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Ingredient")
public class Ingredient {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ingredient_id_generator")
	@SequenceGenerator(name="ingredient_id_generator", sequenceName="ingredient_id_sequence", initialValue=1, allocationSize=1)
	@Column(name="id")
	Integer id;
	
	@Column(name = "ingredient_name")
	private String ingredientName;
	
	@Column(name = "ingredient_description")
	private String description;
	
	@Column(name = "ingredient_details")
	private String details;
	
	@Column(name = "price")
	private Double price;
	
	@Column(name = "availability")
	private Boolean availability;
	
	@Column(name = "image_url")
	private String imageURL;
	
	@Column(name = "recommended_dosage")
	private String recommendedDosage;
	
	@Column(name = "brand")
	private String brand;

	@Column(name = "barcode_number")
	private String barcodeNumber;
	
	@OneToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	@Column(name="ingredient_rank")
	private Integer ingredientRank;
	
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Ingredient_Answer", 
            joinColumns = { @JoinColumn(name = "ingredient_id") }, 
            inverseJoinColumns = { @JoinColumn(name = "answer_id") }
        )
	@JsonIgnore
	private Set<Answer> answers = new HashSet<>();
	
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Ingredient_Allergy", 
            joinColumns = { @JoinColumn(name = "ingredient_id") }, 
            inverseJoinColumns = { @JoinColumn(name = "allergy_id") }
        )
	private Set<Allergy> allergies = new HashSet<>();

	public Ingredient() {
		super();
	}

	public Ingredient(Integer id, String ingredientName, Category category, Integer ingredientRank) {
		super();
		this.id = id;
		this.ingredientName = ingredientName;
		this.category = category;
		this.ingredientRank = ingredientRank;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIngredientName() {
		return ingredientName;
	}

	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Integer getIngredientRank() {
		return ingredientRank;
	}

	public void setIngredientRank(Integer ingredientRank) {
		this.ingredientRank = ingredientRank;
	}

	public Collection<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(Set<Answer> answers) {
		this.answers = answers;
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

	public Boolean getAvailability() {
		return availability;
	}

	public void setAvailability(Boolean availability) {
		this.availability = availability;
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

	public String getBarcodeNumber() {
		return barcodeNumber;
	}

	public void setBarcodeNumber(String barcodeNumber) {
		this.barcodeNumber = barcodeNumber;
	}

	public Set<Allergy> getAllergies() {
		return allergies;
	}

	public void setAllergies(Set<Allergy> allergies) {
		this.allergies = allergies;
	}
	
}
