package com.knackitsolutions.delhimetro.delhimetrobackend.entity;

import com.knackitsolutions.delhimetro.delhimetrobackend.dto.DelhiMetroStationInfoResponse;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "platforms")
@NoArgsConstructor
public class Platform {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String platformNames;
    @ManyToOne
    @JoinColumn(name = "station_id")
    private Station stationInfo;
    private String platformCode;
    @ManyToOne
    @JoinColumn(name = "train_towards")
    private Station trainTowards;
    @ManyToOne
    @JoinColumn(name = "train_towards_second")
    private Station trainTowardsSecond;

    public Platform(DelhiMetroStationInfoResponse.Platform platform){
        setPlatformNames(platform.getPlatformName());
        setPlatformCode(platform.getPlatformCode());
    }
}
