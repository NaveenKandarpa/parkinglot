package org.example.parkinglot.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Bill extends BaseClass{
    @OneToOne
    private Ticket ticket;
    private Date exitTime;
    private int amount;
    @OneToOne
    private Operator billedBy;
    @OneToOne
    private Gate billedAt;
    @Enumerated(EnumType.ORDINAL)
    private BillStatus billStatus;
    @OneToMany
    private List<Payment> payments;
}