package com.knackitsolutions.delhimetro.delhimetrobackend.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PrevNextStationDTO {
    private MetroLineDTO metroLineDTO;
    private StationDTO nextStation;
    private StationDTO previousStation;
}
