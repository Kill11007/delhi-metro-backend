package com.knackitsolutions.delhimetro.delhimetrobackend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Entity
@Data
@Table(name = "station_facilities")
@NoArgsConstructor
public class StationFacility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "station_id")
    private Station stationInfo;

    @ManyToOne
    @JoinColumn(name = "facility_id")
    private Facility facility;

    public StationFacility(Facility facility, Station station){
        setFacility(facility);
        setStationInfo(station);
    }



}
