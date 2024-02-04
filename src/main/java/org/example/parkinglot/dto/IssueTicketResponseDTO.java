package org.example.parkinglot.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.parkinglot.models.Ticket;

@Getter
@Setter
public class IssueTicketResponseDTO {
    private Ticket ticket;
    private ResponseType responseType;
    private String failureMessage;
}
