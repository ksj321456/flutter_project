package com.example.flirting.DTO;

import com.example.flirting.Domain.Food;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FoodDTO {
    private Long id;

    private String carbohydrate;
    private String protein;
    private String fat;
    private String name;

    public static FoodDTO toDTO(Food food) {
        return FoodDTO.builder()
                .id(food.getId())
                .carbohydrate(food.getCarbohydrate())
                .protein(food.getProtein())
                .fat(food.getFat())
                .name(food.getName())
                .build();
    }
}
