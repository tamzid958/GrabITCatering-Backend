package com.xilo.grabit.controller;

import com.xilo.grabit.model.Food;
import com.xilo.grabit.service.FoodService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/foods/")
public class FoodController {
    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping
    public List<Food> findAll(){
        return foodService.findAll();
    }

    @GetMapping("{id}/")
    public Food findById(@PathVariable Long id) {
        return foodService.findById(id);
    }

    @PostMapping
    public Food create(@Valid @RequestBody Food newFood){
        return foodService.create(newFood);
    }

    @PutMapping("{id}/")
    public Food update(@PathVariable Long id, @Valid @RequestBody Food updatedFood){
        return foodService.update(id, updatedFood);
    }

    @DeleteMapping("{id}/")
    public String deleteById(@PathVariable Long id){
        return foodService.deleteById(id);
    }
}
