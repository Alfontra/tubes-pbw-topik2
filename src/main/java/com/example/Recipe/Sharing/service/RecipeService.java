package com.example.Recipe.Sharing.service;

import org.springframework.stereotype.Service;

import com.example.Recipe.Sharing.repository.RecipeRepository;

@Service 
public class RecipeService {
    
    private final RecipeRepository recipeRepository;
    
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }
}
