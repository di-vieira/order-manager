package com.diego.study.ordermanager.service;

import com.diego.study.ordermanager.exception.BusinessException;
import com.diego.study.ordermanager.exception.ResourceNotFound;
import com.diego.study.ordermanager.model.Category;
import com.diego.study.ordermanager.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category findCategory(Integer id) {
        return categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Resource not found - Id: " + id + " - " + CategoryService.class.getName()));
    }

    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    public Page<Category> findCategoriesByPage(Integer pageNumber, Integer recordsPerPage, String direction, String orderBy) {
        PageRequest pageRequest = PageRequest.of(pageNumber, recordsPerPage, Sort.Direction.valueOf(direction), orderBy);
        return categoryRepository.findAll(pageRequest);
    }
    public Category createCategory (Category category) {
        return categoryRepository.save(category);
    }

    public Category updateCategory (Category category) {
        findCategory(category.getId());
        return categoryRepository.save(category);
    }

    public void deleteCategory(Integer id) {
        findCategory(id);
        try {
            categoryRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new BusinessException(String.format("Category ID %d cannot be deleted, because other entities still associated with it", id));
        }
    }

}
