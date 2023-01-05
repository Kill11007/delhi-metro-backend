package com.knackitsolutions.delhimetro.delhimetrobackend.entity;

import com.knackitsolutions.delhimetro.delhimetrobackend.dto.DelhiMetroStationInfoResponse;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "metro_gates")
@NoArgsConstructor
public class MetroGate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String location;
    private String status;
    private String gateName;
    private String gateCode;
    private Double gateLatitude;
    private Double gateLongitude;
    private boolean divyangFriendly;
    @ManyToOne
    @JoinColumn(name = "station_id")

    private Station stationInfo;

    public MetroGate(DelhiMetroStationInfoResponse.MetroGates response){
        setLocation(response.getLocation());
        setStatus(response.getStatus());
        setGateName(response.getGateName());
        setGateCode(response.getGateCode());
        setGateLatitude(response.getGateLatitude());
        setGateLongitude(response.getGateLongitude());
        setDivyangFriendly(response.getDivyangFriendly());
    }
}
