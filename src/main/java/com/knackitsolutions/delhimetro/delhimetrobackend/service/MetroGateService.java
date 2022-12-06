package com.knackitsolutions.delhimetro.delhimetrobackend.service;

import com.knackitsolutions.delhimetro.delhimetrobackend.dto.DelhiMetroStationInfoResponse;
import com.knackitsolutions.delhimetro.delhimetrobackend.entity.MetroGate;
import com.knackitsolutions.delhimetro.delhimetrobackend.entity.Station;
import com.knackitsolutions.delhimetro.delhimetrobackend.entity.StationInfo;
import com.knackitsolutions.delhimetro.delhimetrobackend.repository.MetroGateRepository;
import com.knackitsolutions.delhimetro.delhimetrobackend.repository.StationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MetroGateService {
    private final StationRepository stationRepository;
    private final MetroGateRepository metroGateRepository;


    public List<MetroGate> save(List<DelhiMetroStationInfoResponse.MetroGates> metroGates, StationInfo stationInfo) {
        List<MetroGate> savedMetroGates = new ArrayList<>();
        Optional<Station> station = stationRepository.findById(stationInfo.getId());
        for (DelhiMetroStationInfoResponse.MetroGates gate : metroGates) {
            MetroGate metroGate = new MetroGate(gate);
            station.ifPresent(metroGate::setStationInfo);
            savedMetroGates.add(metroGateRepository.save(metroGate));
        }
        return savedMetroGates;
    }

}
