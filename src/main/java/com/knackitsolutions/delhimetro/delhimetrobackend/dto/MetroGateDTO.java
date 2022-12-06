package com.knackitsolutions.delhimetro.delhimetrobackend.dto;

import com.knackitsolutions.delhimetro.delhimetrobackend.entity.MetroGate;
import lombok.Data;

@Data
public class MetroGateDTO {
    private Long id;
    private String location;
    private String status;
    private String gateName;
    private String gateCode;
    private Double gateLatitude;
    private Double gateLongitude;
    private boolean divyangFriendly;

    public MetroGateDTO(MetroGate metroGate){
        this.id = metroGate.getId();
        this.location = metroGate.getLocation();
        this.status = metroGate.getStatus();
        this.gateName = metroGate.getGateName();
        this.gateCode = metroGate.getGateCode();
        this.gateLatitude = metroGate.getGateLatitude();
        this.gateLongitude = metroGate.getGateLongitude();
        this.divyangFriendly = metroGate.isDivyangFriendly();
    }
}
