package com.example.flirting.DTO;

import com.example.flirting.Domain.Machine;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MachineDTO {
    private Long id;

    private String description;

    private String url;
    private String name;

    public static MachineDTO toDTO(Machine machine) {
        return MachineDTO.builder()
                .id(machine.getId())
                .description(machine.getDescription())
                .url(machine.getUrl())
                .name(machine.getName())
                .build();
    }
}
