package org.example.parkinglot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.parkinglot.models.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    public Ticket saveTicket(Ticket ticket);
}
