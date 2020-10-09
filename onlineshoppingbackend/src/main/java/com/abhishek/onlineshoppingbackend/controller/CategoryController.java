package com.abhishek.onlineshoppingbackend.controller;

import com.abhishek.onlineshoppingbackend.dto.InsertCategoryRequest;
import com.abhishek.onlineshoppingbackend.model.Category;
import com.abhishek.onlineshoppingbackend.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(value = "/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/getAll/active")
    public ResponseEntity<List<Category>> getAllActiveCategories() {
        return new ResponseEntity<>(categoryService.getAllActiveCategories(), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Category>> getAllCategories() {
        return new ResponseEntity<>(categoryService.getAllCategories(), HttpStatus.OK);
    }

    @GetMapping("/get/name/{name}")
    public ResponseEntity<Category> getCategoryByName(@PathVariable(value = "name") String name) {
        if (StringUtils.isBlank(name)) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(categoryService.getCategoryByName(name), HttpStatus.OK);
    }

    @GetMapping("/get/id/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable(value = "id") Long categoryId) {
        Category category = categoryService.getCategoryById(categoryId);

        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Category> saveCategory(@RequestBody InsertCategoryRequest request) {
        Category category = categoryService.getCategoryByName(request.getName());
        if (category != null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        category = categoryService.insertCategory(request);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @PutMapping("/activate/{name}/{activationValue}/getRefreshCategory")
    public ResponseEntity<Category> updateActiveStatusForCategory(@PathVariable(value = "name") String name,
                                                       @PathVariable(value = "activationValue") Boolean activationValue) {
        Category category = categoryService.getCategoryByName(name);
        if (category == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        category = categoryService.updateActiveStatusAndReturnUpdatedCategory(name, activationValue);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PutMapping("/activate/{name}/{activationValue}")
    public ResponseEntity<String> updateActiveStatus(@PathVariable(value = "name") String name,
                                                                  @PathVariable(value = "activationValue") Boolean activationValue) {
        Category category = categoryService.getCategoryByName(name);
        if (category == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        int updated = categoryService.updateActiveStatus(name, activationValue);
        return new ResponseEntity<>("Updated rows : " + updated, HttpStatus.OK);
    }
}
