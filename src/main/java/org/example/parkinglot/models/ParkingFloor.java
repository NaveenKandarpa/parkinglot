package org.example.parkinglot.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Entity
@Getter
@Setter
public class ParkingFloor extends BaseClass{
    private int floorNumber;
    @OneToMany
    private List<ParkingSlot> parkingSlots;
    @Enumerated
    @ElementCollection
    private List<VehicleType> allowedVehicleTypes;
    @Enumerated
    private ParkingFloorStatus parkingFloorStatus;
}