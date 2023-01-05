package com.knackitsolutions.delhimetro.delhimetrobackend.entity;

import com.knackitsolutions.delhimetro.delhimetrobackend.dto.DelhiMetroStationInfoResponse;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "facilities")
@NoArgsConstructor
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String kind;
    private String image;
    @OneToMany(mappedBy = "facility")
    private List<StationFacility> stationFacilities;

    public Facility(DelhiMetroStationInfoResponse.StationFacilities stationFacilities) {
        setKind(stationFacilities.getKind());
    }

    public Facility(DelhiMetroStationInfoResponse.StationFacility stationFacility) {
        setKind(stationFacility.getName());
    }
}
