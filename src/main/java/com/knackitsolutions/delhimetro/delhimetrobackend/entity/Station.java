package com.knackitsolutions.delhimetro.delhimetrobackend.entity;

import com.knackitsolutions.delhimetro.delhimetrobackend.dto.StationResponse;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@Entity
@Table(name = "stations")
@NoArgsConstructor
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer stationId;
    private String stationName;
    private String stationCode;

    @OneToOne(mappedBy = "station")
    @PrimaryKeyJoinColumn
    private StationInfo stationInfo;
    @OneToMany(mappedBy = "startStation")
    private List<MetroLine> startStations;
    @OneToMany(mappedBy = "endStation")
    private List<MetroLine> endStations;
    @OneToMany(mappedBy = "stationInfo")
    private List<MetroGate> metroGates;
    @OneToMany(mappedBy = "stationInfo")
    private List<Platform> platforms;
    @OneToMany(mappedBy = "trainTowards")
    private List<Platform> trainTowardStation;
    @OneToMany(mappedBy = "trainTowardsSecond")
    private List<Platform> trainTowardSecondStation;
    @OneToMany(mappedBy = "stationInfo")
    private List<StationFacility> stationFacilities;
    @OneToMany(mappedBy = "nextStation")
    @ToString.Exclude
    private List<PrevNextStation> nextStations;

    @OneToMany(mappedBy = "prevStation")
    @ToString.Exclude
    private List<PrevNextStation> prevStations;

    @OneToMany(mappedBy = "station")
    @ToString.Exclude
    private List<PrevNextStation> stations;
    public Station(StationResponse stationResponse){
        setStationId(stationResponse.getId());
        setStationName((stationResponse.getName()));
        setStationCode(stationResponse.getCode());
    }
}
