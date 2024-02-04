package org.example.parkinglot.services;

import org.example.parkinglot.exceptions.GateNotFoundException;
import org.example.parkinglot.factories.SlotAssignmentStrategyFactory;
import org.example.parkinglot.models.*;
import org.example.parkinglot.repositories.GateRepository;
import org.example.parkinglot.repositories.ParkingLotRepository;
import org.example.parkinglot.repositories.TicketRepository;
import org.example.parkinglot.repositories.VehicleRepository;
import org.example.parkinglot.strategies.slotAllotmentStrategies.SlotAssignmentStrategy;
import org.example.parkinglot.strategies.slotAllotmentStrategies.SlotAssignmentStrategyType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class TicketService {
    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private ParkingLotRepository parkingLotRepository;
    private TicketRepository ticketRepository;
    @Autowired
    public TicketService(GateRepository gateRepository,
                         VehicleRepository vehicleRepository,
                         ParkingLotRepository parkingLotRepository,
                         TicketRepository ticketRepository){
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.ticketRepository = ticketRepository;
    }

    public Ticket issueTicket(String vehicleNumber,
                    String vehicleOwnerName,
                    VehicleType vehicleType,
                    Long gateId){

        // 1. create a ticket object
        // 2. assign slot
        // 3. return ticket

        Ticket ticket = new Ticket();
        ticket.setEntryTime(new Date());
        // setting the gate
        Optional<Gate> gateOptional = gateRepository.findById(gateId);
        if(gateOptional.isEmpty()){
            throw new GateNotFoundException();
        }
        Gate gate = gateOptional.get();
        ticket.setGeneratedAt(gate);
        ticket.setGeneratedBy(gate.getCurrentOperator());

        // setting the vehicle
        Vehicle savedVehicle;
        Optional<Vehicle> vehicleOptional = vehicleRepository.findById(vehicleNumber);
        if(vehicleOptional.isEmpty()){
            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleNumber(vehicleNumber);
            vehicle.setVehicleType(vehicleType);
            vehicle.setOwnerName(vehicleOwnerName);
            savedVehicle = vehicleRepository.save(vehicle);
        }
        else{
            savedVehicle = vehicleOptional.get();
        }
        ticket.setVehicle(savedVehicle);
        SlotAssignmentStrategyType slotAssignmentStrategyType = parkingLotRepository.findByGate(gate).getSlotAssignmentStrategyType();
        ParkingSlot parkingSlot = SlotAssignmentStrategyFactory
                .getSlotForType(slotAssignmentStrategyType)
                .getSlot(gate, vehicleType);
        ticket.setParkingSlot(parkingSlot);
        ticket = ticketRepository.saveTicket(ticket);
        ticket.setTicketNumber("Ticket - " + ticket.getId());
        return ticket;
    }
}