package com.knackitsolutions.delhimetro.delhimetrobackend.model.dto;

import com.knackitsolutions.delhimetro.delhimetrobackend.model.entity.Station;
import lombok.Data;

@Data
public class StationDTO {
    private long id;
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
