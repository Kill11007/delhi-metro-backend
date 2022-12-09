package com.knackitsolutions.delhimetro.delhimetrobackend.service;

import com.knackitsolutions.delhimetro.delhimetrobackend.client.StationInfoClient;
import com.knackitsolutions.delhimetro.delhimetrobackend.dto.DelhiMetroStationInfoResponse;
import com.knackitsolutions.delhimetro.delhimetrobackend.dto.StationInfoDTO;
import com.knackitsolutions.delhimetro.delhimetrobackend.entity.Station;
import com.knackitsolutions.delhimetro.delhimetrobackend.entity.StationInfo;
import com.knackitsolutions.delhimetro.delhimetrobackend.repository.StationInfoRepository;
import com.knackitsolutions.delhimetro.delhimetrobackend.repository.StationRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;


import java.util.List;
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
    private final PrevNextService prevNextService;

    @Transactional
    public StationInfoDTO saveStationInfo(String code) {
        try {
            DelhiMetroStationInfoResponse delhiMetroStationInfoResponse = stationInfoClient.infoResponse(code);
            StationInfo stationInfo = saveStationInfo(delhiMetroStationInfoResponse);
           // Optional<Station> station = stationRepository.findByStationCode(stationInfo.getStation().getStationCode());
            metroLineService.save(delhiMetroStationInfoResponse.getMetroLines());
            metroGateService.save(delhiMetroStationInfoResponse.getGatesList(), stationInfo);
            platformService.save(delhiMetroStationInfoResponse.getPlatformList(), stationInfo);
            facilityService.saveStationFacility(delhiMetroStationInfoResponse.getStationFacility(), stationInfo);
            facilityService.saveStationFacilities(delhiMetroStationInfoResponse.getStationFacilities(), stationInfo);
            prevNextService.savePrevNextStations(delhiMetroStationInfoResponse.getPreviousNextStations(), stationInfo);
            return new StationInfoDTO(stationInfo);
        } catch (Exception e) {
            log.info(e.toString());
        }
        return null;
    }

    private StationInfo saveStationInfo(DelhiMetroStationInfoResponse delhiMetroStationInfoResponse) {
        StationInfo stationInfo = new StationInfo(delhiMetroStationInfoResponse);
        Optional<StationInfo> stationInfoById = stationInfoRepository.findByStationStationId(delhiMetroStationInfoResponse.getId());
        if (stationInfoById.isEmpty()) {
            Optional<Station> byStationCode = stationRepository.findByStationCode(delhiMetroStationInfoResponse.getStationCode());
            byStationCode.ifPresent(stationInfo::setStation);
//            if (byStationCode.isPresent()) {
//                Station station = byStationCode.get();
//                stationInfo.setStation(station);
////                station.setStationInfo(stationInfo);
//            }
        } else {
            throw new RuntimeException("Data Already Exists");
        }
        return stationInfoRepository.save(stationInfo);
    }

    public StationInfoDTO get(String word) {
        Optional<Station> station =stationRepository.findByStationCode(word);
        return station.map(StationInfoDTO::new).orElseThrow();
    }
}
