package com.xilo.grabit.controller;

import com.xilo.grabit.model.Category;
import com.xilo.grabit.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/categories/")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> findAll() {
       return categoryService.findAll();
    }

    @GetMapping("{id}/")
    public Category findById(@PathVariable Long id) {
        return categoryService.findById(id);
    }

    @ResponseBody @PostMapping
    public Category create(@Valid @RequestBody Category newCategory){
        return categoryService.create(newCategory);
    }

    @ResponseBody @PutMapping("{id}/")
    public Category update(@PathVariable Long id, @Valid @RequestBody Category updatedCategory){
        return categoryService.update(id, updatedCategory);
    }

    @DeleteMapping("{id}/")
    public String deleteById(@PathVariable Long id) {
        return categoryService.deleteById(id);
    }
}
