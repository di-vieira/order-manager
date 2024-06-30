package com.diego.study.ordermanager.controller;

import com.diego.study.ordermanager.dto.CategoryDTO;
import com.diego.study.ordermanager.model.Category;
import com.diego.study.ordermanager.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

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
    @Operation(summary = "Find a specific category by its ID")
    public ResponseEntity<Category> findCategory(@PathVariable Integer id) {
        return ResponseEntity.ok().body(categoryService.findCategory(id));
    }

    @GetMapping()
    @Operation(summary = "List all categories")
    public ResponseEntity<List<CategoryDTO>> findAllCategories(){
        List<CategoryDTO> categories = categoryService.findAllCategories()
                .stream()
                .map(category -> new CategoryDTO(category.getId(), category.getName()))
                .toList();
        return ResponseEntity.ok().body(categories);
    }

    @GetMapping("/page")
    @Operation(summary = "List categories following a specific page definition")
    public ResponseEntity<Page<CategoryDTO>> findCategoriesByPage(
            @RequestParam(value = "page", defaultValue = "0") Integer pageNumber,
            @RequestParam(value = "records", defaultValue = "10") Integer recordsPerPage,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction,
            @RequestParam(value = "orderBy", defaultValue = "name") String orderBy) {
        Page<CategoryDTO> categories = categoryService.findCategoriesByPage(pageNumber, recordsPerPage, direction, orderBy)
                .map(category -> new CategoryDTO(category.getId(), category.getName()));
        return ResponseEntity.ok().body(categories);
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

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing category")
    public ResponseEntity<Void> updateCategory (@RequestBody Category category, @PathVariable Integer id) {
        category.setId(id);
        categoryService.updateCategory(category);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an existing category")
    public ResponseEntity<Void> deleteCategory(@PathVariable Integer id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
