package com.example.flirting.Repository;

import com.example.flirting.Domain.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    public Optional<List<Exercise>> findByUserId(Long Id);
}
