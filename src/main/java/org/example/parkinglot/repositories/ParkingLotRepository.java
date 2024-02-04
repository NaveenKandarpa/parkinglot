package org.example.parkinglot.repositories;

import org.example.parkinglot.models.Gate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.example.parkinglot.models.ParkingLot;

import java.util.Optional;

public interface ParkingLotRepository extends JpaRepository<ParkingLot, Long> {
    ParkingLot findByGate(Gate gate);
}
