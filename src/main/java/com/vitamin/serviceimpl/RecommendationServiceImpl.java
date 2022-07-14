package com.vitamin.serviceimpl;	

import java.util.ArrayList;	
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vitamin.entity.Ingredient;
import com.vitamin.entity.Recommendation;
import com.vitamin.entity.SelectedAnswer;
import com.vitamin.entity.UserAnswer;
import com.vitamin.repository.IngredientRepository;
import com.vitamin.repository.RecommendationRepository;
import com.vitamin.service.RecommendationService;

@Service
public class RecommendationServiceImpl implements RecommendationService {
	
	@Autowired
	private RecommendationRepository repository;
	
	@Autowired
	private IngredientRepository ingredientRepository;

	@Override
	public Recommendation processUserRequest(Collection<UserAnswer> userAnswers) {
		Recommendation recommendation = new Recommendation();
		List<Ingredient> ingredients = new ArrayList<>();
		List<Integer> answerIds = new ArrayList<>();
		for(UserAnswer userAnswer : userAnswers){
			System.out.println(userAnswer.getQuestionId());
			System.out.println(userAnswer.getQuestionDescription());
			for(SelectedAnswer selectedAnswer : userAnswer.getSelectedAnswers()){
				System.out.println(selectedAnswer.getAnswerId());
				System.out.println(selectedAnswer.getSelectedAnswerDescription());
				
				if(selectedAnswer.getAnswerId() != null){
					answerIds.add(selectedAnswer.getAnswerId());
				}
				//List<Ingredient> answerIngredients = ingredientRepository.findByAnswerId(selectedAnswer.getAnswerId());
				//ingredients.addAll(answerIngredients);
			}
			
			
		}
		
		List<Ingredient> answerIngredients = ingredientRepository.findByAnswerId(answerIds);
		
		ingredients.addAll(answerIngredients);
		
		ingredients = findIngredientsByCategoryAndIngredientRank(ingredients);
		
		List<Ingredient> finalIngredients = new ArrayList<>();
		
		for(Ingredient i : ingredients){
			finalIngredients.add(i);
		}
		System.out.println("Total: "+finalIngredients.size());
		
		if(finalIngredients.size() > 5){
			for(int i = ingredients.size() - 1; i >= 5; i--){
				finalIngredients.remove(i);
			}
		}
		System.out.println("Total: "+finalIngredients.size());
		recommendation.setIngredients(finalIngredients);
		return recommendation;
	}

	private List<Ingredient> findIngredientsByCategoryAndIngredientRank(List<Ingredient> ingredients) {
		System.out.println(ingredients.size());
		if(ingredients.size() <=5){
			return ingredients;
		}
		
		ingredients = sortIngredientsByCatgoryRank(ingredients);
		
		
		return ingredients;
	}

	private List<Ingredient> sortIngredientsByCatgoryRank(List<Ingredient> ingredients) {

	     for (int i = 0; i < ingredients.size() - 1; i++)
	        {
	            int index = i;
	            for (int j = i + 1; j < ingredients.size(); j++)
	                if (ingredients.get(j).getCategory().getCategoryRank() < ingredients.get(index).getCategory().getCategoryRank()) 
	                    index = j;
	      
	            Ingredient priorityIngredient = ingredients.get(index);  
	            ingredients.set(index, ingredients.get(i));
	            ingredients.set(i, priorityIngredient);
	            
	        }
	       		
		return ingredients;
	}
}
