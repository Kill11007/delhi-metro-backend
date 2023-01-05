package com.knackitsolutions.delhimetro.delhimetrobackend.entity;

import com.knackitsolutions.delhimetro.delhimetrobackend.dto.DelhiMetroStationInfoResponse;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.function.Function;


@Data
@Table(name = "station_info")
@Entity
@NoArgsConstructor

public class StationInfo {
    @Id
    private Long id;
    @JoinColumn(name = "id")
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId
    @ToString.Exclude
    private Station station;
    private boolean interchange;
    private double latitude;
    private double longitude;
    private String mobile;
    private String landline;
    private String stationType;
    private double xCoords;
    private double yCoords;

    public StationInfo(DelhiMetroStationInfoResponse response) {
        Function<String, Double> trimThenParse = s -> Double.parseDouble(s.trim());
        setInterchange(response.getInterchange());
//        setLatitude(trimThenParse.apply(response.getLatitude().substring(1)));
        setLatitude(trimThenParse.apply(response.getLatitude()));
        setLongitude(trimThenParse.apply(response.getLongitude()));
        setMobile(response.getMobile());
        setLandline(response.getLandline());
        setStationType(response.getStationType());
        setXCoords(trimThenParse.apply(response.getXCoords()));
        setYCoords(trimThenParse.apply(response.getYCoords()));
    }

}
