package com.diego.study.ordermanager.service;

import com.diego.study.ordermanager.model.Category;
import com.diego.study.ordermanager.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category getCategory(Integer id){
        Category category = categoryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Not found"));
        return category;
    }
}
