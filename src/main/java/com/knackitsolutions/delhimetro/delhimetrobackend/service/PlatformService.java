package com.knackitsolutions.delhimetro.delhimetrobackend.service;

import com.knackitsolutions.delhimetro.delhimetrobackend.dto.DelhiMetroStationInfoResponse;
import com.knackitsolutions.delhimetro.delhimetrobackend.entity.Platform;
import com.knackitsolutions.delhimetro.delhimetrobackend.entity.Station;
import com.knackitsolutions.delhimetro.delhimetrobackend.entity.StationInfo;
import com.knackitsolutions.delhimetro.delhimetrobackend.repository.PlatformRepository;
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
public class PlatformService {
    private final StationRepository stationRepository;
    private final PlatformRepository platformRepository;
    public List<Platform> save(List<DelhiMetroStationInfoResponse.Platform> platformList, StationInfo stationInfo) {
        log.info("Response: {}", platformList);
        List<Platform> platforms = new ArrayList<>();
        Optional<Station> station = stationRepository.findById(stationInfo.getId());
        for (DelhiMetroStationInfoResponse.Platform platform : platformList) {
            if (platformRepository.existsByPlatformCodeAndStationInfoId(platform.getPlatformCode(), stationInfo.getId())) {
                continue;
            }
            Platform platform1 = new Platform(platform);
            Optional<Station> trainTowards = stationRepository.findByStationCode(platform.getTrainTowards().getStationCode());
            if (platform.getTrainTowardsSecond()  != null) {
                Optional<Station> trainTowardsSecond = stationRepository
                        .findByStationCode((platform.getTrainTowardsSecond().getStationCode()));
                trainTowardsSecond.ifPresent(platform1::setTrainTowardsSecond);
            }
            station.ifPresent(platform1::setStationInfo);
            trainTowards.ifPresent(platform1::setTrainTowards);
            platforms.add(platformRepository.save(platform1));
        }
        return platforms;
    }
}
