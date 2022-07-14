package com.vitamin.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.vitamin.entity.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {
	/*@Query("select distinct i from Ingredient i inner join i.answers a where a.id=:answerId")
	public List<Ingredient> findByAnswerId(@Param("answerId") Integer answerId);*/
	
	@Query("select distinct i from Ingredient i inner join i.answers a where a.id IN (:answerIds)")
	public List<Ingredient> findByAnswerId(@Param("answerIds") List<Integer> answerIds);
	
	@Query("select case when (count(i) > 0)then true else false end from Ingredient i inner join i.category c where c.id = :categoryId and i.ingredientRank = :ingredientRank")
	public boolean findByCategoryIdAndRank(@Param("categoryId") Integer categoryId, @Param("ingredientRank") Integer ingredientRank);
	
	public Collection<Ingredient> findById(Integer id);

	@Query("select case when (count(a) > 0)then true else false end from Ingredient i inner join i.answers a where i.id = :ingredientId")
	public boolean isIngredientLinkedWithAnyAnswer(@Param("ingredientId")  Integer ingredientId);
	
	
	
}
