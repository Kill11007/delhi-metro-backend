package com.knackitsolutions.delhimetro.delhimetrobackend.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DelhiMetroStationInfoResponse {
     private List<StationStatus> stationStatuses;
     @JsonProperty("metro_lines")
     private List<MetroLine> metroLines;
     @JsonProperty("prev_next_stations")
     private List<Map<String, List<Line>>> previousNextStations;
     private int id;
     @JsonProperty("station_code")
     private String stationCode;
     @JsonProperty("station_name")
     private String stationName;
     @JsonProperty("station_commercial_name")
     private String stationCommercialName;
     @JsonProperty("station_type")
     private String stationType;
     private Boolean interchange;
     private double latitude;
     private double longitude;
     @JsonProperty("x_coords")
     private double xCoords;
     @JsonProperty("y_coords")
     private double yCoords;
     private String mobile;
     private String landline;
     @JsonProperty("station_facility")
     private List<StationFacility> stationFacility;
     @JsonProperty("gates")
     private List<MetroGates> gatesList;
     @JsonProperty("platforms")
     private List<Platform> platformList;
     @JsonProperty("stations_facilities")
     private List<StationFacilities> stationFacilities;




     @Data
     private static class StationStatus{
     }
     @Data
     @Builder
     @NoArgsConstructor
     @AllArgsConstructor
     @JsonIgnoreProperties(ignoreUnknown = true)
     public static class MetroLine {
          private Integer id;
          private String name;
          @JsonProperty("line_color")
          private String lineColor;
          @JsonProperty("line_code")
          private String lineCode;
          @JsonProperty("primary_color_code")
          private String primaryColourCode;
          @JsonProperty("secondary_color_code")
          private String secondaryColourCode;
          @JsonProperty("class_primary")
          private String classPrimary;
          @JsonProperty("class_secondary")
          private String classSecondary;
          @JsonProperty("start_station")
          private String startStation;
          @JsonProperty("end_station")
          private String endStation;
          private String status;



     }
     @Data
     @Builder
     @NoArgsConstructor
     @AllArgsConstructor
     @JsonIgnoreProperties(ignoreUnknown = true)
     private static class PreviousNextStation{
          Map<String, List<Line>> stations;
     }
     @Data
     @JsonIgnoreProperties(ignoreUnknown = true)
     public static class Line{
          @JsonProperty("line_id")
          private String lineId;
          @JsonProperty("prev_station")
          private Station previousStation;
          @JsonProperty("next_station")
          private Station nextStation;
          @JsonProperty("line_color")
          private String lineColor;
          @JsonProperty("primary_color_code")
          private String primaryColorCode;
          @JsonProperty("secondary_color_code")
          private String secondaryColorCode;
          @JsonProperty("class_primary")
          private String classPrimary;
          @JsonProperty("class_secondary")
          private String classSecondary;

     }
     @Data
     @JsonIgnoreProperties(ignoreUnknown = true)
     public static class Station{
          private Integer id;
          @JsonProperty("station_name")
          private String stationName;
          @JsonProperty("station_code")
          private String stationCode;
     }

     @Data
     @Builder
     @NoArgsConstructor
     @AllArgsConstructor
     @JsonIgnoreProperties(ignoreUnknown = true)
     public static class StationFacility{
          private String name;

     }



     @Data
     @Builder
     @NoArgsConstructor
     @AllArgsConstructor
     @JsonIgnoreProperties(ignoreUnknown = true)
     public static class MetroGates{
          @JsonProperty("gate_name")
          private String gateName;
          @JsonProperty("gate_code")
          private String gateCode;
          private String location;
          @JsonProperty("gate_latitude")
          private Double gateLatitude;
          @JsonProperty("gate_longitude")
          private Double gateLongitude;
          @JsonProperty("divyang_friendly")
          private Boolean divyangFriendly;
          private String status;
     }

     @Data
     @Builder
     @NoArgsConstructor
     @AllArgsConstructor
     @JsonIgnoreProperties(ignoreUnknown = true)
     public static class Platform {
          @JsonProperty("platform_name")
          private String platformName;
          @JsonProperty("train_towards")
          private Station trainTowards;
          @JsonProperty("platform_code")
          private String platformCode;
          @JsonProperty("train_towards_second")
          private Station trainTowardsSecond;
     }



     @Data
     @Builder
     @NoArgsConstructor
     @AllArgsConstructor
     @JsonIgnoreProperties(ignoreUnknown = true)
     public static class StationFacilities{
          private String kind;
          private String image;

     }



}
