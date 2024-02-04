package org.example.parkinglot.models;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.example.parkinglot.strategies.slotAllotmentStrategies.SlotAssignmentStrategy;
import org.example.parkinglot.strategies.slotAllotmentStrategies.SlotAssignmentStrategyType;

import java.util.List;

@Entity
@Getter
@Setter
public class ParkingLot extends BaseClass{
    private String address;
    @OneToMany
    private List<ParkingFloor> parkingFloors;
    @OneToMany
    private List<Gate> gates;
    @Enumerated
    private ParkingLotStatus parkingLotStatus;
    @Enumerated
    @ElementCollection
    private List<VehicleType> allowedVehicleTypes;
    @Enumerated
    private SlotAssignmentStrategyType slotAssignmentStrategyType;
}
