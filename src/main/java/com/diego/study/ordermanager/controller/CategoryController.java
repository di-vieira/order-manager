package com.diego.study.ordermanager.controller;

import com.diego.study.ordermanager.model.Category;
import com.diego.study.ordermanager.service.CategoryService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.Option;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/{id}")
    @Operation(summary = "List all categories")
    public ResponseEntity<Category> findCategory(@PathVariable Integer id) {
        try {
            return new ResponseEntity<Category>(categoryService.getCategory(id), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }
    }
}
