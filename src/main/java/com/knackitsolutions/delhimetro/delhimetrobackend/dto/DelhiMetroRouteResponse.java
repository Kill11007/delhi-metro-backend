package com.knackitsolutions.delhimetro.delhimetrobackend.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
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
  private StationStatus fromStationStatus;
  private StationStatus toStationStatus;
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
    private Integer lineNo;
    private List<Path> path;
    private String pathTime;
    private Map<Integer, String> mapPath;
    private Double statusInterchangeTime;
    private String start;
    private String end;
    private String direction;
    private String towardsStation;
    private String platformName;
    private String newStartTime;
    private String newEndTime;
  }

  @Data
  private static class Path{
    private String name;
    private String status;
  }

}
