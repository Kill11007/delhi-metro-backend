package com.knackitsolutions.delhimetro.delhimetrobackend.service;

import com.knackitsolutions.delhimetro.delhimetrobackend.client.StationInfoClient;
import com.knackitsolutions.delhimetro.delhimetrobackend.dto.DelhiMetroStationInfoResponse;
import com.knackitsolutions.delhimetro.delhimetrobackend.dto.MetroLineDTO;
import com.knackitsolutions.delhimetro.delhimetrobackend.entity.MetroLine;
import com.knackitsolutions.delhimetro.delhimetrobackend.entity.Station;
import com.knackitsolutions.delhimetro.delhimetrobackend.entity.StationInfo;
import com.knackitsolutions.delhimetro.delhimetrobackend.repository.MetroGateRepository;
import com.knackitsolutions.delhimetro.delhimetrobackend.repository.MetroLineRepository;
import com.knackitsolutions.delhimetro.delhimetrobackend.repository.StationInfoRepository;
import com.knackitsolutions.delhimetro.delhimetrobackend.repository.StationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MetroLineService {
    private final MetroLineRepository metroLineRepository;
    private final StationRepository stationRepository;


    public List<MetroLine> save(List<DelhiMetroStationInfoResponse.MetroLine> metroLines) {
        List<MetroLine> savedMetroLines = new ArrayList<>();
        for (DelhiMetroStationInfoResponse.MetroLine metroLine:
             metroLines) {
            MetroLine entity = null;

            Station startStation = stationRepository.findByStationNameLike(metroLine.getStartStation()).get(0);
            Station endStation = stationRepository.findByStationNameLike(metroLine.getEndStation()).get(0);
            Optional<MetroLine> byLineId = metroLineRepository.findByLineId(metroLine.getId());
            if (byLineId.isPresent()) {
                entity = byLineId.get();
                entity.update(metroLine);
            }else{
                entity = new MetroLine(metroLine);
            }
            entity.setStartStation(startStation);
            entity.setEndStation(endStation);
            MetroLine save = metroLineRepository.save(entity);
            savedMetroLines.add(save);
        }
        return savedMetroLines;
    }



}

