package com.knackitsolutions.delhimetro.delhimetrobackend.entity;

import com.knackitsolutions.delhimetro.delhimetrobackend.dto.StationResponse;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "stations")
@NoArgsConstructor
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int stationId;
    private String stationName;
    private String stationCode;

    public Station(StationResponse stationResponse){
        setStationId(stationResponse.getId());
        setStationName((stationResponse.getName()));
        setStationCode(stationResponse.getCode());
    }
}
