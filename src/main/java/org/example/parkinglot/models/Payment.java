package org.example.parkinglot.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Payment extends BaseClass{
    private int amount;
    @Enumerated
    private PaymentMode paymentMode;
    private String refId;
    @Enumerated
    private PaymentStatus paymentStatus;

}
