package org.example.parkinglot.strategies.slotAllotmentStrategies;

import org.example.parkinglot.models.Gate;
import org.example.parkinglot.models.ParkingSlot;
import org.example.parkinglot.models.VehicleType;

public interface SlotAssignmentStrategy {
    public ParkingSlot getSlot(Gate gate, VehicleType vehicleType);
}
