package org.example.parkinglot.controllers;

import org.example.parkinglot.dto.IssueTicketRequestDTO;
import org.example.parkinglot.dto.IssueTicketResponseDTO;
import org.example.parkinglot.dto.ResponseType;
import org.example.parkinglot.models.Ticket;
import org.example.parkinglot.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TicketController {
    private TicketService ticketService;
    @Autowired
    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }
    public IssueTicketResponseDTO issueTicket(IssueTicketRequestDTO issueTicketRequestDTO){
        IssueTicketResponseDTO response = new IssueTicketResponseDTO();
        try{
            Ticket ticket = ticketService.issueTicket(issueTicketRequestDTO.getVehicleNumber(),
                    issueTicketRequestDTO.getVehicleOwnerName(),
                    issueTicketRequestDTO.getVehicleType(),
                    issueTicketRequestDTO.getGateId());

            response.setTicket(ticket);
            response.setResponseType(ResponseType.SUCCESS);
        }
        catch(Exception e){
            response.setResponseType(ResponseType.FAILURE);
            response.setFailureMessage(e.getMessage());
        }
        return response;
    }
}
// implement RandomSLotAssignmentStrategy
