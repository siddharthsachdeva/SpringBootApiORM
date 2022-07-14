package com.vitamin.service;

import java.util.Collection;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.vitamin.dto.IngredientDTO;
import com.vitamin.dto.OoviResponse;
import com.vitamin.entity.Ingredient;

public interface IngredientService {

	OoviResponse addOrEditIngredient(Ingredient ingredient, MultipartFile file);

	OoviResponse linkIngredientsWithAnswers(Collection<Map<String, Integer>> ingredientsAndAnswersMap);

	Collection<Ingredient> fetchAllIngredients();

	OoviResponse deleteIngredient(Integer id);

}
