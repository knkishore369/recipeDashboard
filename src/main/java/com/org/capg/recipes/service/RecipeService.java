package com.org.capg.recipes.service;

import com.org.capg.recipes.entity.Recipe;
import com.org.capg.recipes.repository.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RecipeService {

    @Autowired
    RecipeRepository recipeRepository;

    Logger logger = LoggerFactory.getLogger(RecipeService.class);

    public Recipe saveRecipe(Recipe recipe) {
        logger.info("::::: RecipeService ::::: dish_type :::: " + recipe.getDish_type());
        logger.info("::::: RecipeService ::::: ingredients :::: " + recipe.getIngredients());
        Recipe recipeDetails = recipeRepository.save(recipe);

        return recipeDetails;
    }
}
