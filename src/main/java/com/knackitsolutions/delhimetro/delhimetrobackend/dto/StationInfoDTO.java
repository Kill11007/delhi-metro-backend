package com.knackitsolutions.delhimetro.delhimetrobackend.dto;

import com.knackitsolutions.delhimetro.delhimetrobackend.entity.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@NoArgsConstructor
public class StationInfoDTO  {
    private boolean interchange;
    private double latitude;
    private double longitude;
    private String mobile;
    private String landline;
    private String stationType;
    private double xCoords;
    private double yCoords;
    private Integer id;
    private List<StationFacilitiesDTO>  stationFacilitiesDTO;
    private List<MetroGateDTO> metroGateDTO;
    private List<PlatformDTO> platformDTO;

    private List<PrevNextStationDTO> prevNextStationDTO;

    public StationInfoDTO(StationInfo stationInfo ){
        this.interchange = stationInfo.isInterchange();
        this.latitude = stationInfo.getLatitude();
        this.longitude = stationInfo.getLongitude();
        this.mobile = stationInfo.getMobile();
        this.landline = stationInfo.getLandline();
        this.stationType = stationInfo.getStationType();
        this.xCoords = stationInfo.getXCoords();
        this.yCoords = stationInfo.getYCoords();
        this.id = stationInfo.getStation().getStationId();
    }
    public StationInfoDTO(Station station){
        this(station.getStationInfo());
        this.prevNextStationDTO = new ArrayList<>();
        for(PrevNextStation entity: station.getStations()){
            PrevNextStationDTO dto = new PrevNextStationDTO();
            MetroLineDTO metroLineDTO = new MetroLineDTO(entity.getMetroLine());
            Station nextStation = entity.getNextStation();
            StationDTO stationDTO = new StationDTO(nextStation);
            dto.setNextStation(stationDTO);
            dto.setMetroLineDTO(metroLineDTO);
            prevNextStationDTO.add(dto);
        }

        for (PrevNextStation entity : station.getStations()) {
            Optional<PrevNextStationDTO> first = prevNextStationDTO.stream()
                    .filter(dto -> dto.getMetroLineDTO().getId() == entity.getMetroLine().getId()).findFirst();
            if (first.isPresent()) {
                PrevNextStationDTO prevNextStationDTO1 = first.get();
                Optional.ofNullable(entity.getPrevStation()).map(StationDTO::new).ifPresent(prevNextStationDTO1::setPreviousStation);

//                prevNextStationDTO1.setPreviousStation(new StationDTO(entity.getPrevStation()));
            }
        }
        this.platformDTO = new ArrayList<>();
        for(Platform entity : station.getPlatforms()){
            PlatformDTO dto = new PlatformDTO(entity);
            platformDTO.add(dto);
        }
        this.metroGateDTO = new ArrayList<>();
        for(MetroGate entity : station.getMetroGates()){
            MetroGateDTO dto = new MetroGateDTO(entity);
            metroGateDTO.add(dto);
        }
        this.stationFacilitiesDTO = new ArrayList<>();
        for(StationFacility entity : station.getStationFacilities()){
            StationFacilitiesDTO dto = new StationFacilitiesDTO(entity.getFacility());
            stationFacilitiesDTO.add(dto);
        }
    }
}
