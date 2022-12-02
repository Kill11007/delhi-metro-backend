package com.knackitsolutions.delhimetro.delhimetrobackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DelhiMetroRouteResponse {
  private Integer stations;
  private String from;
  private String to;
  @JsonProperty("from_station_status")
  private StationStatus fromStationStatus;
  @JsonProperty("to_station_status")
  private StationStatus toStationStatus;
  @JsonProperty("total_time")
  private String totalTime;
  private BigDecimal fare;
  private List<Route> route;
  private String message;
  @Data
  private static class StationStatus{
    private String status;
    private String title;
    private String note;
  }

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  @Builder
  private static class Route{
    private String line;
    @JsonProperty("line_no")
    private Integer lineNo;
    private List<Path> path;
    @JsonProperty("path_time")
    private String pathTime;
    @JsonProperty("map-path")
    private List<String> mapPath;
    @JsonProperty("station_interchange_time")
    private Double statusInterchangeTime;
    private String start;
    private String end;
    private String direction;
    @JsonProperty("towards_station")
    private String towardsStation;
    @JsonProperty("platform_name")
    private String platformName;
    @JsonProperty("new_start_time")
    private String newStartTime;
    @JsonProperty("new_end_time")
    private String newEndTime;
  }

  @Data
  private static class Path{
    private String name;
    private String status;
  }

}
