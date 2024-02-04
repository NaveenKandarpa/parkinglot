package org.example.parkinglot.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Gate extends BaseClass{

    private int gateNumber;
    @Enumerated(EnumType.ORDINAL)
    private GateType gateType;
    @OneToOne
    private Operator currentOperator;
    @Enumerated
    private GateStatus gateStatus;

}
