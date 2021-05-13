package com.org.capg.recipes.controller;

import com.org.capg.recipes.entity.Recipe;
import com.org.capg.recipes.repository.RecipeRepository;
import com.org.capg.recipes.service.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/recipes")
@Slf4j
@CrossOrigin(origins = "*")
public class RecipesDashboardController {

    @Autowired
    RecipeService recipeService;

    @Autowired
    RecipeRepository recipeRepository;

    Logger logger = LoggerFactory.getLogger(RecipesDashboardController.class);

    @PostMapping("/createRecipe")
    public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe) {

        logger.info("Entering RecipesDashboardController ::: createRecipe");
        logger.info("Entering RecipesDashboardController ::: createRecipe ::: dish type ::: " + recipe.getDish_type());
        try {
            Recipe recipeDetails = recipeService.saveRecipe(recipe);
            return new ResponseEntity<>(recipeDetails, HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateRecipe/{id}")
    public ResponseEntity<Recipe> updateRecipe(@PathVariable("id") long id, @RequestBody Recipe recipe) {

        logger.info("Entering RecipesDashboardController ::: updateRecipe");
        Optional<Recipe> recipeDetails = recipeRepository.findById(id);

        if (recipeDetails.isPresent()) {
            Recipe recipeData = recipeDetails.get();
            recipeData.setDish_type(recipe.getDish_type());
            recipeData.setNum_of_people(recipe.getNum_of_people());
            recipeData.setIngredients(recipe.getIngredients());
            recipeData.setCooking_instruction(recipe.getCooking_instruction());
            return new ResponseEntity<>(recipeRepository.save(recipeData), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteRecipe/{id}")
    public ResponseEntity<HttpStatus> deleteRecipe(@PathVariable("id") long id) {

        logger.info("Entering RecipesDashboardController ::: deleteRecipe");
        try {
            recipeRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteAllRecipes")
    public ResponseEntity<HttpStatus> deleteAllRecipes() {

        logger.info("Entering RecipesDashboardController ::: deleteAllRecipes");
        try {
            recipeRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
