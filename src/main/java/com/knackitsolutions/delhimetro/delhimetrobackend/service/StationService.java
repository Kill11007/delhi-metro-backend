package com.knackitsolutions.delhimetro.delhimetrobackend.service;

import com.knackitsolutions.delhimetro.delhimetrobackend.client.StationClient;
import com.knackitsolutions.delhimetro.delhimetrobackend.dto.StationDTO;
import com.knackitsolutions.delhimetro.delhimetrobackend.entity.Station;
import com.knackitsolutions.delhimetro.delhimetrobackend.dto.StationResponse;
import com.knackitsolutions.delhimetro.delhimetrobackend.repository.StationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StationService {
    private final StationRepository stationRepository;
    private final StationClient client;

    public List<StationDTO> get(String start) {
        return stationRepository.findByStationNameLike(start + "%").stream().map(StationDTO:: new).toList();
    }

    public List<StationResponse> save(String letter) {
        List<StationResponse> stationResponses = client.stationsResponse(letter);
        List<Station> entityList = stationResponses.stream().map(Station::new).map(stationRepository::save).toList();
        return stationResponses;
    }

    public void saveAll() {
        List<Station> all = stationRepository.findAll();
        final int number = 13;
        all
                .stream()
                .map(Station::getStationName)
                .filter(s -> s.length() > number)
                .map(s -> s.substring(0, number))
                .map(client::stationsResponse)
                .flatMap(Collection::stream)
                .filter(stationResponse -> !stationRepository.existsByStationId(stationResponse.getId()))
                .map(Station::new)
                .map(stationRepository::save)
                .toList();

    }

    public void saveAny() {
        List<Station> all = stationRepository.findAll();
        Set<String> chars = Arrays.stream("A quick crazy brown fox jumps over the lazy dog"
                .split(""))
                .filter(s -> !Objects.equals(s, " "))
                .map(String::toUpperCase)
                .collect(Collectors.toSet());
        System.out.println(chars);
        System.out.println(chars.size());
        for (String s: chars) {
            for(String ss: chars){
                for(String sss: chars){
                    String str = s + ss + sss;
                    System.out.println("Chars: " + str);
                    store(str);
                }
            }
        }
        System.out.println("Finished...");
    }

    private void store(String chars){
        client.stationsResponse(chars)
                .stream()
                .filter(stationResponse -> !stationRepository.existsByStationId(stationResponse.getId()))
                .map(Station::new)
                .map(stationRepository::save)
                .toList();
    }


    public List<StationDTO> getAll() {
        return stationRepository.findAll().stream().map(StationDTO::new).toList();
    }
}
