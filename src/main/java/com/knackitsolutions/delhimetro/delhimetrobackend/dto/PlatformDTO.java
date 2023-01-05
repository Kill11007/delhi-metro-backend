package com.knackitsolutions.delhimetro.delhimetrobackend.dto;

import com.knackitsolutions.delhimetro.delhimetrobackend.entity.Platform;
import com.knackitsolutions.delhimetro.delhimetrobackend.entity.Station;
import lombok.Data;

@Data
public class PlatformDTO {
    private Long id;
    private String platformNames;
    private String platformCode;
    private StationDTO trainTowards;
    private StationDTO trainTowardsSecond;

    public PlatformDTO(Platform platform){
        this.id = platform.getId();
        this.platformNames = platform.getPlatformNames();
        this.platformCode = platform.getPlatformCode();
        this.trainTowards = new StationDTO(platform.getTrainTowards());
        if(platform.getTrainTowardsSecond() != null) {
            this.trainTowardsSecond = new StationDTO(platform.getTrainTowardsSecond());
        }
    }
}
