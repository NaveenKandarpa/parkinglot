package org.example.parkinglot;

import jakarta.annotation.PostConstruct;
import org.example.parkinglot.controllers.TicketController;
import org.example.parkinglot.dto.IssueTicketRequestDTO;
import org.example.parkinglot.dto.IssueTicketResponseDTO;
import org.example.parkinglot.models.VehicleType;
import org.example.parkinglot.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ParkinglotApplication {
    private static TicketController ticketController;
    public ParkinglotApplication(TicketController ticketController){
        this.ticketController = ticketController;
    }
    @PostConstruct
    public void run(){
        IssueTicketRequestDTO issueTicketRequestDTO = IssueTicketRequestDTO.builder()
                .gateId(1L)
                .vehicleNumber("A123")
                .vehicleOwnerName("Naveen")
                .vehicleType(VehicleType.BIKE)
                .build();
        IssueTicketResponseDTO issueTicketResponseDTO = ticketController.issueTicket(issueTicketRequestDTO);
//        System.out.println(issueTicketResponseDTO);
//        System.out.println("hello");
    }
    public static void main(String[] args) {

        SpringApplication.run(ParkinglotApplication.class, args);
    }
}