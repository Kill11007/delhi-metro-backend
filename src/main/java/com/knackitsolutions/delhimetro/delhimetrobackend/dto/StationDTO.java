package com.knackitsolutions.delhimetro.delhimetrobackend.dto;

import com.knackitsolutions.delhimetro.delhimetrobackend.entity.Station;
import lombok.Data;

@Data
public class StationDTO {
    private Long id;
    private int stationId;
    private String stationName;
    private String stationCode;

    public StationDTO(Station station){
        this.id = station.getId();
        this.stationId = station.getStationId();
        this.stationName = station.getStationName();
        this.stationCode = station.getStationCode();
    }

}
