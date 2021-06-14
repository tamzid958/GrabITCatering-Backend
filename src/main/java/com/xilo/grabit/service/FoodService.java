package com.xilo.grabit.service;

import com.xilo.grabit.model.Food;
import com.xilo.grabit.respository.CategoryRepository;
import com.xilo.grabit.respository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {
    private final FoodRepository foodRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public FoodService(FoodRepository foodRepository, CategoryRepository categoryRepository) {
        this.foodRepository = foodRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<Food> findAll(){
        return foodRepository.findAll();
    }

    public Food findById(Long id) {
        return foodRepository.findById(id).orElse(null);
    }

    public Food create(Food newFood) {
        Food food = new Food(
                newFood.getImg(),
                newFood.getTitle(),
                newFood.getPrice(),
                true,
                newFood.getDescription(),
                newFood.getCategory());
        foodRepository.save(food);
        return food;
    }

    public Food update(Long id, Food updatedFood) {
        return foodRepository.findById(id).flatMap(
            food -> categoryRepository.findById(updatedFood.getCategory().getId()).map(
            category -> {
                food.setImg(updatedFood.getImg());
                food.setTitle(updatedFood.getTitle());
                food.setPrice(updatedFood.getPrice());
                food.setAvailable(updatedFood.isAvailable());
                food.setDescription(updatedFood.getDescription());
                food.setCategory(category);
                foodRepository.save(food);
                return food;
            })).orElse(null);
    }

    public String deleteById(Long id) {
        foodRepository.deleteById(id);
        return "Deleted Successfully";
    }
}
