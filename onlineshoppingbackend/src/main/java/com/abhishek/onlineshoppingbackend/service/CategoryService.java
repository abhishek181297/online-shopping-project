package com.abhishek.onlineshoppingbackend.service;

import com.abhishek.onlineshoppingbackend.dao.CategoryRepository;
import com.abhishek.onlineshoppingbackend.dto.InsertCategoryRequest;
import com.abhishek.onlineshoppingbackend.model.Category;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
    public Category getCategoryByName(String name) {
        return categoryRepository.findByName(name);
    }
    public List<Category> getAllActiveCategories() {
        return categoryRepository.findByActive(true);
    }

    public Category insertCategory(InsertCategoryRequest request) {
        Category category = new Category();
        category.setName(request.getName());
        category.setDescription(request.getDescription());
        category.setImageUrl(request.getImageUrl());
        category.setActive(request.isActive());
        return categoryRepository.save(category);
    }

    public Category updateActiveStatusAndReturnUpdatedCategory(String name, Boolean activationValue) {

        int updatedRows = categoryRepository.updateCategoryStatusAndRefreshCache(name, activationValue);

        log.info("Updated Category name - {},value - {}, count - {}", name,activationValue, updatedRows);
        return getCategoryByName(name);
    }

    public int updateActiveStatus(String name, Boolean activationValue) {

        int updatedRows = categoryRepository.updateCategoryStatus(name, activationValue);

        log.info("Updated Category name - {},value - {}, count - {}", name,activationValue, updatedRows);
        return updatedRows;
    }

    public Category getCategoryById(Long categoryId) {
        Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
        return optionalCategory.orElse(null);
    }
}
