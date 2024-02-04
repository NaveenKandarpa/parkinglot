package org.example.parkinglot.repositories;

import org.example.parkinglot.models.Gate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GateRepository extends JpaRepository<Gate, Long> {
    @Override
    Optional<Gate> findById(Long aLong);
}
