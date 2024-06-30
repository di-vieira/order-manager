package com.diego.study.ordermanager.service;

import com.diego.study.ordermanager.exception.ResourceNotFound;
import com.diego.study.ordermanager.model.Category;
import com.diego.study.ordermanager.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category findCategory(Integer id) {
        return categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Resource not found - Id: " + id + " - " + CategoryService.class.getName()));
    }

    public Category createCategory (Category category) {
        return categoryRepository.save(category);
    }

    public Category updateCategory (Category category) {
        findCategory(category.getId());
        return categoryRepository.save(category);
    }
}
