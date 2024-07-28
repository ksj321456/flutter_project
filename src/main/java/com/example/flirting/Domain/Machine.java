package com.example.flirting.Domain;

import com.example.flirting.DTO.MachineDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Machine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String url;
    private String name;

    public static Machine toEntity(MachineDTO machineDTO) {
        return Machine.builder()
                .id(machineDTO.getId())
                .description(machineDTO.getDescription())
                .url(machineDTO.getUrl())
                .name(machineDTO.getName())
                .build();
    }
}
