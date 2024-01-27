package com.example.MoreFlavour.food;

public record FoodResponseDTO(Long id, String tittle, String img, Integer price) {
    public FoodResponseDTO(Food food){
        this(food.getId(), food.getTittle(), food.getImg(), food.getPrice());
    }
}
