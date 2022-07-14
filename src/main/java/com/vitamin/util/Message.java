package com.vitamin.util;

public interface Message {
	String SUCCESS = "success";
	String ERROR = "error";
	String SOMETHING_WENT_WONG = "Something went wrong!";
	String QUESTION_ADDED = "Question added successfully.";
	String INGREDIENT_WITH_SAME_CATEGORY_AND_RANK = "Ingredient with same category and rank already exists.";
	String INGREDIENTS_ADDED = "Ingredient(s) added successfully.";
	String CATEGORY_DOES_NOT_EXISTS = "Category doesn't exists.";
	String INGREDIENTS_ANSWERS_LINKED = "ingredients linked with Answers successfully.";
	String INGREDIENT_DELETED = "Ingredient deleted successfully.";
	String INGREDIENT_LINKED_ANSWER_ERROR = "Ingredient is linked with answer, please change the linking before deleting this ingredient.";
	String ADMIN_LOGGED_IN = "Admin logged in successfully.";
	String ADMIN_ADDED = "Admin added successfully.";
	String ADMIN_ALREADY_EXISTS = "Admin already exists.";
	String EMAILID_USERNAME_PASS_ROLE_MANDATORY  = "Mandatory information missing! Please provide email id, username, password and role.";
	String INVALID_USERNAME_OR_PASS = "Invalid username or password.";
	String INGREDIENT_UNLINKED = "Ingredient unlinked successfully.";
	String INGREDIENT_LINKED = "Ingredient linked successfully.";
	String INGREDIENTS_EDITED = "Ingredient edited successfully.";
}
