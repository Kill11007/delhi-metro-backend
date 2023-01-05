package com.knackitsolutions.delhimetro.delhimetrobackend.dto;

import com.knackitsolutions.delhimetro.delhimetrobackend.entity.Facility;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class StationFacilitiesDTO {
    private Long id;
    private String kind;
    private String image;

    public StationFacilitiesDTO(Facility facility){
        this.id = facility.getId();
        this.kind = facility.getKind();
        this.image = facility.getImage();
    }
}
