package org.example.parkinglot.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ManyToAny;

@Entity
@Getter
@Setter
public class ParkingSlot extends BaseClass{
    private String slotNumber;
    @Enumerated
    private VehicleType vehicleType;
    @Enumerated
    private ParkingSlotStatus parkingSlotStatus;
    @ManyToOne
    private ParkingFloor parkingFloor;
}
