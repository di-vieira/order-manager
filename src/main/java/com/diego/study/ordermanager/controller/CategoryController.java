package com.diego.study.ordermanager.controller;

import com.diego.study.ordermanager.model.Category;
import com.diego.study.ordermanager.service.CategoryService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.swing.text.html.Option;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/test")
    public String healthChech() {
        return "Rest is working";
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "List all categories")
    public ResponseEntity<Category> findCategory(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(categoryService.getCategory(id), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    @Operation(summary = "Create a new category")
    public ResponseEntity<Void> createCategory (@RequestBody Category category) {
        categoryService.createCategory(category);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(category.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }
}
