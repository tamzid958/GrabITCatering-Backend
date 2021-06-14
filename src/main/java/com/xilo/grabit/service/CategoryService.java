package com.xilo.grabit.service;

import com.xilo.grabit.model.Category;
import com.xilo.grabit.respository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public Category create(Category newCategory) {
        Category category = new Category(
          newCategory.getImg(),
          newCategory.getTitle(),
          newCategory.getSubtitle()
        );
        categoryRepository.save(category);
        return category;
    }

    public Category update(Long id, Category updatedCategory) {
       return categoryRepository.findById(id).map(
            category -> {
                category.setImg(updatedCategory.getImg());
                category.setTitle(updatedCategory.getTitle());
                category.setSubtitle(updatedCategory.getSubtitle());
                categoryRepository.save(category);
                return category;
            }
        ).orElse(null);
    }

    public String deleteById(Long id) {
        categoryRepository.deleteById(id);
        return "Deleted Successfully";
    }
}
