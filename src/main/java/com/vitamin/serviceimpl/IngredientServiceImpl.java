package com.vitamin.serviceimpl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vitamin.dto.OoviResponse;
import com.vitamin.entity.Answer;
import com.vitamin.entity.Category;
import com.vitamin.entity.Ingredient;
import com.vitamin.exception.ServiceException;
import com.vitamin.repository.AnswerRepository;
import com.vitamin.repository.CategoryRepository;
import com.vitamin.repository.IngredientRepository;
import com.vitamin.service.IngredientService;
import com.vitamin.util.CloudnaryUtil;
import com.vitamin.util.Constant;
import com.vitamin.util.Message;

@Service
public class IngredientServiceImpl implements IngredientService {

	@Autowired
	private IngredientRepository repository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private AnswerRepository answerRepository;

	@Override
	public OoviResponse addOrEditIngredient(Ingredient ingredient, MultipartFile file) {
		OoviResponse response = new OoviResponse();
		try {
			
				Integer categoryId = ingredient.getCategory().getId();
				Integer ingredientRank = ingredient.getIngredientRank();

				boolean isPresentSameRankAndCategory = repository.findByCategoryIdAndRank(categoryId, ingredientRank);
				
				//If id is not null then this API is called for edit purpose.
				if (isPresentSameRankAndCategory && ingredient.getId() == null) {
					throw new ServiceException(Constant.ERROR_STATUS_CODE, Message.INGREDIENT_WITH_SAME_CATEGORY_AND_RANK);
				} else if (!categoryRepository.validateCategoryId(categoryId)) {
					throw new ServiceException(Constant.ERROR_STATUS_CODE, Message.CATEGORY_DOES_NOT_EXISTS);
				}
				
				if(file != null) {
					String imageURL = uploadImage(ingredient.getIngredientName(), file);
					ingredient.setImageURL(imageURL);
				}
				
				if(ingredient.getId() == null) {
					response.setMessage(Message.INGREDIENTS_ADDED);
				}else {
					response.setMessage(Message.INGREDIENTS_EDITED);
				}
				
				Category category = categoryRepository.findById(categoryId);
				ingredient.setCategory(category);
			
			repository.save(ingredient);
			response.setStatusCode(Constant.SUCCESS_STATUS_CODE);
			
		} catch (ServiceException se) {
			response.setStatusCode(se.getStatusCode());
			response.setMessage(se.getMessage());
			se.printStackTrace();
		} catch (Exception e) {
			response.setStatusCode(Constant.ERROR_STATUS_CODE);
			response.setMessage(Message.SOMETHING_WENT_WONG);
			e.printStackTrace();
		}
		return response;
	}

	private String uploadImage(String ingredientName, MultipartFile image) throws IOException {
		File file = new File(image.getOriginalFilename());
		file.createNewFile();
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(image.getBytes());
		fos.close();
		CloudnaryUtil uploadUtil = new CloudnaryUtil();

		String url = uploadUtil.uploadImage(file, ingredientName, "ingredients");

		file.delete();
		return url;
	}

	@Override
	public OoviResponse linkIngredientsWithAnswers(Collection<Map<String, Integer>> ingredientsAndAnswers) {
		OoviResponse response = new OoviResponse();
		try {
			for (Map<String, Integer> map : ingredientsAndAnswers) {
				Collection<Ingredient> ingredient = null;
				Collection<Answer> answer = null;
				for (String key : map.keySet()) {
					if (key.equalsIgnoreCase(Constant.INGREDIENT_ID)) {
						ingredient = repository.findById(map.get(key));
					} else if (key.equalsIgnoreCase(Constant.ANSWER_ID)) {
						answer = answerRepository.findById(map.get(key));
					}
				}
				
				for (Ingredient i : ingredient) {
					i.getAnswers().addAll(answer);
					repository.save(i);
				}
				for (Answer a : answer) {
					a.getIngredients().addAll(ingredient);
					answerRepository.save(a);
				}
			}
			response.setStatusCode(Constant.SUCCESS_STATUS_CODE);
			response.setMessage(Message.INGREDIENTS_ANSWERS_LINKED);
		} catch (Exception e) {
			response.setStatusCode(Constant.ERROR_STATUS_CODE);
			response.setMessage(Message.SOMETHING_WENT_WONG);
		}
		return response;
	}

	@Override
	public Collection<Ingredient> fetchAllIngredients() {
		List<Ingredient> ingredients = new ArrayList<>();
		try {
			repository.findAll().forEach(ingredients::add);
			/*List<Integer> indexesToRemove = new ArrayList<>();
			for(int i = 0; i < ingredients.size(); i++  ) {
				for(int j = i+1; j < ingredients.size(); i++  ) {
					if(ingredients.get(i).getIngredientName().equalsIgnoreCase(ingredients.get(j).getIngredientName())) {
						ingredients.get(i).geta
						indexesToRemove.add(j);
					}
				}
			}*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ingredients;
	}

	@Override
	public OoviResponse deleteIngredient(Integer id) {
		OoviResponse response = new OoviResponse();
		try {
			
			boolean isIngredientLinkedWithAnyAnswer = repository.isIngredientLinkedWithAnyAnswer(id);
			System.out.println("Is the ingredient linked with any answer: " + isIngredientLinkedWithAnyAnswer);
			
			if(isIngredientLinkedWithAnyAnswer){
				throw new ServiceException(Constant.ERROR_STATUS_CODE, Message.INGREDIENT_LINKED_ANSWER_ERROR);
			}
			
			repository.delete(id);
			response.setStatusCode(Constant.SUCCESS_STATUS_CODE);
			response.setMessage(Message.INGREDIENT_DELETED);
		}catch(ServiceException se){
			se.printStackTrace();
			response.setStatusCode(Constant.ERROR_STATUS_CODE);
			response.setMessage(se.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			response.setStatusCode(Constant.ERROR_STATUS_CODE);
			response.setMessage(Message.SOMETHING_WENT_WONG);
		}
		return response;
	}
}
