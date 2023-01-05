package com.knackitsolutions.delhimetro.delhimetrobackend.service;

import com.knackitsolutions.delhimetro.delhimetrobackend.dto.DelhiMetroStationInfoResponse;
import com.knackitsolutions.delhimetro.delhimetrobackend.entity.MetroLine;
import com.knackitsolutions.delhimetro.delhimetrobackend.entity.PrevNextStation;
import com.knackitsolutions.delhimetro.delhimetrobackend.entity.Station;
import com.knackitsolutions.delhimetro.delhimetrobackend.entity.StationInfo;
import com.knackitsolutions.delhimetro.delhimetrobackend.repository.MetroLineRepository;
import com.knackitsolutions.delhimetro.delhimetrobackend.repository.PrevNextStationRepository;
import com.knackitsolutions.delhimetro.delhimetrobackend.repository.StationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class PrevNextService {
    private final StationRepository stationRepository;
    private final MetroLineRepository metroLineRepository;
    private final PrevNextStationRepository prevNextStationRepository;

    public List<PrevNextStation> savePrevNextStations(List<Map<String, List<DelhiMetroStationInfoResponse.Line>>> previousNextStations,
                                                      StationInfo stationInfo){
        List<PrevNextStation> prevNextStations = new ArrayList<>();
        Optional<Station> station = stationRepository.findById(stationInfo.getId());
        for (Map<String, List<DelhiMetroStationInfoResponse.Line>> lineMap : previousNextStations) {
            Collection<List<DelhiMetroStationInfoResponse.Line>> values = lineMap.values();
            for (List<DelhiMetroStationInfoResponse.Line> lineList : values){
                for(DelhiMetroStationInfoResponse.Line line : lineList){
                    PrevNextStation prevNextStation = new PrevNextStation();
                    Optional<MetroLine> byLineId = metroLineRepository.findByLineId(line.getLineId());
                    if(line.getNextStation() != null) {
                        Optional<Station> nextStation = stationRepository.findByStationCode(line.getNextStation().getStationCode());
                        nextStation.ifPresent(prevNextStation::setNextStation);
                    }
                    if(line.getPreviousStation() != null){
                        Optional<Station> prevStation = stationRepository.findByStationCode(line.getPreviousStation().getStationCode());
                        prevStation.ifPresent(prevNextStation::setPrevStation);
                    }
                    byLineId.ifPresent(prevNextStation::setMetroLine);
                    station.ifPresent(prevNextStation::setStation);
                    prevNextStations.add(prevNextStationRepository.save(prevNextStation));
                }
            }
        }
        return  prevNextStations;
    }
}
