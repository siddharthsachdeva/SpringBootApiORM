package com.vitamin.service;

import java.util.Collection;

import com.vitamin.dto.LinkUnlinkIngredientDTO;
import com.vitamin.dto.OoviResponse;
import com.vitamin.entity.Ingredient;

public interface AnswerService {

	Collection<Ingredient> fetchIngredientsByAnswerId(Integer answerId);

	OoviResponse unlinkIngredientFromAnswer(LinkUnlinkIngredientDTO dto);

	OoviResponse linkIngredientToAnswer(LinkUnlinkIngredientDTO dto);

}
