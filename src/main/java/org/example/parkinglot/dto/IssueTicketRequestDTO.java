package org.example.parkinglot.dto;

import lombok.*;
import org.example.parkinglot.models.VehicleType;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IssueTicketRequestDTO {
    private String vehicleNumber;
    private String vehicleOwnerName;
    private VehicleType vehicleType;
    private Long gateId;
}
