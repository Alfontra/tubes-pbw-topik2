package com.example.Recipe.Sharing.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Recipe.Sharing.model.Category;
import com.example.Recipe.Sharing.repository.CategoryRepository;

@Service 
public class CategoryService {
    
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // menampilkan semua kategori
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    // menambahkan kategori
    public void addCategory(Category category) {
        if (category.getName() == null ||
            category.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Nama kategori tidak boleh kosong");
        }

        category.setName(category.getName().trim());

        if (categoryRepository.existByName(category.getName())) {
            throw new IllegalArgumentException("Kategori sudah tersedia");
        }

        categoryRepository.save(category);
    }
}
