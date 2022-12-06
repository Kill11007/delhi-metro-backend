package com.knackitsolutions.delhimetro.delhimetrobackend.entity;

import com.knackitsolutions.delhimetro.delhimetrobackend.dto.DelhiMetroStationInfoResponse;
import com.knackitsolutions.delhimetro.delhimetrobackend.dto.StationInfoDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Table(name = "station_info")
@Entity
@NoArgsConstructor

public class StationInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JoinColumn(name = "id", referencedColumnName = "stationId")
    @OneToOne
    @MapsId
    private Station station;
    private boolean interchange;
    private double latitude;
    private double longitude;
    private String mobile;
    private String landline;
    private String stationType;
    private double xCoords;
    private double yCoords;




    @OneToMany(mappedBy = "nextStation")
    private List<PrevNextStation> nextStations;

    @OneToMany(mappedBy = "prevStation")
    private List<PrevNextStation> prevStations;

    @OneToMany(mappedBy = "station")
    private List<PrevNextStation> stations;



    public StationInfo(DelhiMetroStationInfoResponse response) {
        setInterchange(response.getInterchange());
        setLatitude(response.getLatitude());
        setLongitude(response.getLongitude());
        setMobile(response.getMobile());
        setLandline(response.getLandline());
        setStationType(response.getStationType());
        setXCoords(response.getXCoords());
        setYCoords(response.getYCoords());
    }

}
