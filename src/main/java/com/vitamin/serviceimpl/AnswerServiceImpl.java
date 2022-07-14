package com.vitamin.serviceimpl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vitamin.dto.LinkUnlinkIngredientDTO;
import com.vitamin.dto.OoviResponse;
import com.vitamin.entity.Answer;
import com.vitamin.entity.Ingredient;
import com.vitamin.repository.AnswerRepository;
import com.vitamin.repository.IngredientRepository;
import com.vitamin.service.AnswerService;
import com.vitamin.util.Constant;
import com.vitamin.util.Message;

@Service
public class AnswerServiceImpl implements AnswerService {
	
	@Autowired
	AnswerRepository repository;
	
	@Autowired
	private IngredientRepository ingredientRepository;

	@Override
	public Collection<Ingredient> fetchIngredientsByAnswerId(Integer answerId) {
		Collection<Ingredient> ingredients = null;
		try{
			ingredients = repository.getIngredientsByAnswerId(answerId);	
		}catch(Exception e){
			e.printStackTrace();
		}
		return ingredients;
	}

	@Override
	public OoviResponse unlinkIngredientFromAnswer(LinkUnlinkIngredientDTO dto) {
		OoviResponse response = new OoviResponse();
		try{
			Answer answer = repository.findOne(dto.getAnswerId());
			Ingredient ingredient = ingredientRepository.findOne(dto.getIngredientId());
			answer.getIngredients().remove(ingredient);
			ingredient.getAnswers().remove(answer);
			repository.save(answer);
			ingredientRepository.save(ingredient);
			response.setStatusCode(Constant.SUCCESS_STATUS_CODE);
			response.setMessage(Message.INGREDIENT_UNLINKED);
			
		}catch(Exception e){
			e.printStackTrace();
			response.setStatusCode(Constant.ERROR_STATUS_CODE);
			response.setMessage(Message.SOMETHING_WENT_WONG);
		}
		return response;
	}

	@Override
	public OoviResponse linkIngredientToAnswer(LinkUnlinkIngredientDTO dto) {
		OoviResponse response = new OoviResponse();
		try{
			Answer answer = repository.findOne(dto.getAnswerId());
			Ingredient ingredient = ingredientRepository.findOne(dto.getIngredientId());
			answer.getIngredients().add(ingredient);
			ingredient.getAnswers().add(answer);
			repository.save(answer);
			ingredientRepository.save(ingredient);
			
			response.setStatusCode(Constant.SUCCESS_STATUS_CODE);
			response.setMessage(Message.INGREDIENT_LINKED);
			
		}catch(Exception e){
			e.printStackTrace();
			response.setStatusCode(Constant.ERROR_STATUS_CODE);
			response.setMessage(Message.SOMETHING_WENT_WONG);
		}
		return response;
	}
}
