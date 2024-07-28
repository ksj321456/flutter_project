package com.example.flirting.Domain;

import com.example.flirting.DTO.FoodDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String carbohydrate;
    private String protein;
    private String fat;
    private String name;

    public static Food toEntity(FoodDTO foodDTO) {
        return Food.builder()
                .id(foodDTO.getId())
                .carbohydrate(foodDTO.getCarbohydrate())
                .protein(foodDTO.getProtein())
                .fat(foodDTO.getFat())
                .name(foodDTO.getName())
                .build();
    }
}
