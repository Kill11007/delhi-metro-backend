package com.knackitsolutions.delhimetro.delhimetrobackend.dto;

import com.knackitsolutions.delhimetro.delhimetrobackend.entity.StationInfo;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class StationInfoDTO  {
    private boolean interchange;
    private double latitude;
    private double longitude;
    private String mobile;
    private String landline;
    private String stationType;
    private double xCoords;
    private double yCoords;
    private Integer id;
    public StationInfoDTO(StationInfo stationInfo){
        this.interchange = stationInfo.isInterchange();
        this.latitude = stationInfo.getLatitude();
        this.longitude = stationInfo.getLongitude();
        this.mobile = stationInfo.getMobile();
        this.landline = stationInfo.getLandline();
        this.stationType = stationInfo.getStationType();
        this.xCoords = stationInfo.getXCoords();
        this.yCoords = stationInfo.getYCoords();
        this.id = stationInfo.getStation().getStationId();
    }
}
