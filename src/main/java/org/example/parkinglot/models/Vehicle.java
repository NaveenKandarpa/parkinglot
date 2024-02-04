package org.example.parkinglot.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Vehicle extends BaseClass{
    private String vehicleNumber;
    private String ownerName;
    @Enumerated
    private VehicleType vehicleType;
}
