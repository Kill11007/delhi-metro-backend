package com.knackitsolutions.delhimetro.delhimetrobackend.service;

import com.knackitsolutions.delhimetro.delhimetrobackend.dto.DelhiMetroStationInfoResponse;
import com.knackitsolutions.delhimetro.delhimetrobackend.entity.Facility;
import com.knackitsolutions.delhimetro.delhimetrobackend.entity.Station;
import com.knackitsolutions.delhimetro.delhimetrobackend.entity.StationFacility;
import com.knackitsolutions.delhimetro.delhimetrobackend.entity.StationInfo;
import com.knackitsolutions.delhimetro.delhimetrobackend.repository.FacilityRepository;
import com.knackitsolutions.delhimetro.delhimetrobackend.repository.StationFacilityRepository;
import com.knackitsolutions.delhimetro.delhimetrobackend.repository.StationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class FacilityService {
    private final StationFacilityRepository stationFacilityRepository;
    private final FacilityRepository facilityRepository;
    private final StationRepository stationRepository;

    public List<Facility> saveStationFacility(List<DelhiMetroStationInfoResponse.StationFacility> facilityList, StationInfo stationInfo) {
        List<Facility> facilities = new ArrayList<>();
        Optional<Station> station = stationRepository.findById(stationInfo.getId());
        for(DelhiMetroStationInfoResponse.StationFacility stationFacility : facilityList){
            Optional<Facility> facilityOptional = facilityRepository.findByKind(stationFacility.getName());
            Facility facility = null;
            if(facilityOptional.isEmpty()) {
                Facility save = new Facility(stationFacility);
                facility = facilityRepository.save(save);
            }
            else {
                facility = facilityOptional.get();
            }
            StationFacility stationFacility1 = new StationFacility(facility, station.get());
            StationFacility save = stationFacilityRepository.save(stationFacility1);
        }
        return facilities;
    }

    public List<Facility> saveStationFacilities(List<DelhiMetroStationInfoResponse.StationFacilities> facilityList, StationInfo stationInfo) {
        log.info("Response: {}", facilityList);
        List<Facility> facilityList1 = new ArrayList<>();
        Optional<Station> station = stationRepository.findById(stationInfo.getId());
        for(DelhiMetroStationInfoResponse.StationFacilities stationFacilities : facilityList){
            Optional<Facility> facilityOptional = facilityRepository.findByKind(stationFacilities.getKind());
            Facility facility = null;
            if(facilityOptional.isEmpty()){
                Facility save = new Facility(stationFacilities);
                facility = facilityRepository.save(save);
            }else {
                facility = facilityOptional.get();
            }
            StationFacility stationFacility = new StationFacility(facility, station.get());
            StationFacility save1 = stationFacilityRepository.save(stationFacility);
            facilityList1.add(facility);
        }
        return facilityList1;
    }
}
