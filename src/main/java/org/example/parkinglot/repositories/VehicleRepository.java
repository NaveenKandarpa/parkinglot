package org.example.parkinglot.repositories;

import org.example.parkinglot.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VehicleRepository extends JpaRepository<Vehicle,  Long> {
    Optional<Vehicle> findById(String vehicleNumber);
    public Vehicle saveVehicle(Vehicle vehicle);
}
