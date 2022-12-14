package com.knackitsolutions.delhimetro.delhimetrobackend.controller;


import com.knackitsolutions.delhimetro.delhimetrobackend.dto.StationInfoDTO;
import com.knackitsolutions.delhimetro.delhimetrobackend.service.StationInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin("*")
@RestController
@RequestMapping("/station-info")
@RequiredArgsConstructor
public class StationInfoController {
    private final StationInfoService stationInfoService;

    @GetMapping("/{word}")
    public ResponseEntity<StationInfoDTO> getInfo(@PathVariable String word){
        StationInfoDTO stationInfo = stationInfoService.saveStationInfo(word);
        return ResponseEntity.ok(stationInfo);
    }
    @GetMapping("/{word}/word")
    public ResponseEntity<StationInfoDTO> getAll(@PathVariable String word){
        StationInfoDTO stationInfoDTO = stationInfoService.get(word);
        return ResponseEntity.ok(stationInfoDTO);
    }

}
