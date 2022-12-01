package com.knackitsolutions.delhimetro.delhimetrobackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StationResponse {
    private int id;
    @JsonProperty("station_name")
    private String name;
    @JsonProperty("station_code")
    private String code;


}
