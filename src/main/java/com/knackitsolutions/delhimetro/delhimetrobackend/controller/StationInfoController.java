package com.knackitsolutions.delhimetro.delhimetrobackend.controller;

import com.knackitsolutions.delhimetro.delhimetrobackend.client.StationInfoClient;
import com.knackitsolutions.delhimetro.delhimetrobackend.dto.DelhiMetroStationInfoResponse;
import com.knackitsolutions.delhimetro.delhimetrobackend.dto.StationInfoDTO;
import com.knackitsolutions.delhimetro.delhimetrobackend.service.StationInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@CrossOrigin("*")
@RestController
@RequestMapping("/station-info")
@RequiredArgsConstructor
public class StationInfoController {
    private final StationInfoService stationInfoService;
    private final StationInfoClient stationInfoClient;
    @GetMapping("/{word}")
    public ResponseEntity<StationInfoDTO> getInfo(@PathVariable String word){
        StationInfoDTO stationInfo = stationInfoService.saveStationInfo(word);
        return ResponseEntity.ok(stationInfo);
    }


}
