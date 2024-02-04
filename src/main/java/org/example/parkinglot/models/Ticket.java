package org.example.parkinglot.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Ticket extends BaseClass{
    private String ticketNumber;
    @OneToOne
    private Vehicle vehicle;
    @OneToOne
    private ParkingSlot parkingSlot;
    @ManyToOne
    private Gate generatedAt;
    @ManyToOne
    private Operator generatedBy;
    private Date entryTime;
}
