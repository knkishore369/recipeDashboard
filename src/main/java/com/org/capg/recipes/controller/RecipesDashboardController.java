package com.org.capg.recipes.controller;

import com.org.capg.recipes.entity.Recipe;
import com.org.capg.recipes.service.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recipes")
@Slf4j
@CrossOrigin(origins = "*")
public class RecipesDashboardController {

    @Autowired
    RecipeService recipeService;

    Logger logger = LoggerFactory.getLogger(RecipesDashboardController.class);

    @PostMapping("/createRecipe")
    public long createRecipe(@RequestBody Recipe recipe) {

        logger.info("::::: controller ::::: dish_type :::: " + recipe.getDish_type());
        logger.info("::::: controller ::::: ingredients :::: " + recipe.getIngredients());
        recipeService.saveRecipe(recipe);
        logger.info(":: recipe.getId() ::" + recipe.getId());
        return recipe.getId();
    }

    @DeleteMapping("/deleteRecipe/{id}")
    public void deleteRecipe(@PathVariable("id") long id) {
        recipeService.delete(id);
    }
}
