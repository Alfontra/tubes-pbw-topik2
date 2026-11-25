package com.example.Recipe.Sharing.controller;

import org.springframework.stereotype.Controller;

import com.example.Recipe.Sharing.service.RecipeService;

@Controller 
public class RecipeController {
    
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }
}
