package com.example.Recipe.Sharing.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Recipe.Sharing.model.Category;
import com.example.Recipe.Sharing.service.CategoryService;

@Controller 
@RequestMapping("/categories")
public class CategoryController {
    
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // menampilkan semua kategori
    @GetMapping 
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    // menambahkan kategori
    @PostMapping 
    public String addCategory(@RequestBody Category category) {
        try {
            categoryService.addCategory(category);

            return "Kategori berhasil ditambahkan";
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }
}
