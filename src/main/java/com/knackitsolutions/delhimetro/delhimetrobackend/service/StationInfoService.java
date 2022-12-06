package com.knackitsolutions.delhimetro.delhimetrobackend.service;

import com.knackitsolutions.delhimetro.delhimetrobackend.client.StationInfoClient;
import com.knackitsolutions.delhimetro.delhimetrobackend.dto.DelhiMetroStationInfoResponse;
import com.knackitsolutions.delhimetro.delhimetrobackend.dto.StationInfoDTO;
import com.knackitsolutions.delhimetro.delhimetrobackend.entity.Station;
import com.knackitsolutions.delhimetro.delhimetrobackend.entity.StationInfo;
import com.knackitsolutions.delhimetro.delhimetrobackend.repository.StationInfoRepository;
import com.knackitsolutions.delhimetro.delhimetrobackend.repository.StationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;


import java.util.Optional;


@Service
@RequiredArgsConstructor
@Log4j2
public class StationInfoService {
    private final StationInfoClient stationInfoClient;
    private final StationRepository stationRepository;
    private final StationInfoRepository stationInfoRepository;
    private final MetroLineService metroLineService;
    private final MetroGateService metroGateService;
    private final PlatformService platformService;
    private final FacilityService facilityService;

    public StationInfoDTO saveStationInfo(String code) {
        DelhiMetroStationInfoResponse delhiMetroStationInfoResponse = stationInfoClient.infoResponse(code);
        log.info(delhiMetroStationInfoResponse);
        StationInfo stationInfo = saveStationInfo(delhiMetroStationInfoResponse);
//        Optional<Station> station = stationRepository.findById(stationInfo.getId());
        metroLineService.save(delhiMetroStationInfoResponse.getMetroLines());
        metroGateService.save(delhiMetroStationInfoResponse.getGatesList(), stationInfo);
        platformService.save(delhiMetroStationInfoResponse.getPlatformList(), stationInfo);
        facilityService.saveStationFacility(delhiMetroStationInfoResponse.getStationFacility(), stationInfo);
        facilityService.saveStationFacilities(delhiMetroStationInfoResponse.getStationFacilities(), stationInfo);
        return new StationInfoDTO(stationInfo);
    }

    private StationInfo saveStationInfo(DelhiMetroStationInfoResponse delhiMetroStationInfoResponse) {
        StationInfo stationInfo = new StationInfo(delhiMetroStationInfoResponse);
        Optional<Station> byStationCode = stationRepository.findByStationCode(delhiMetroStationInfoResponse.getStationCode());
        if (byStationCode.isEmpty()) {
            Station station = new Station();
            station.setStationId(delhiMetroStationInfoResponse.getId());
            station.setStationCode(delhiMetroStationInfoResponse.getStationCode());
            station.setStationName(delhiMetroStationInfoResponse.getStationName());
            Station save = stationRepository.save(station);
            stationInfo.setStation(save);
        } else {
            stationInfo.setStation(byStationCode.get());
        }
        return stationInfoRepository.save(stationInfo);
    }
}
