package com.example.MoreFlavour.controller;

import com.example.MoreFlavour.food.Food;
import com.example.MoreFlavour.food.FoodRepository;
import com.example.MoreFlavour.food.FoodRequestDTO;
import com.example.MoreFlavour.food.FoodResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("MoreFlavour")
public class FoodController {
    @Autowired
    private FoodRepository repository;
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveFood(@RequestBody FoodRequestDTO data) {
        Food foodData = new Food(data);
        repository.save(foodData);
        return;
    }
    @GetMapping
    public List<FoodResponseDTO> getAll(){

        List<FoodResponseDTO> foodList = repository.findAll().stream().map(FoodResponseDTO::new).toList();
        return foodList;
    }
}
