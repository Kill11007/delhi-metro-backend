package com.knackitsolutions.delhimetro.delhimetrobackend.controller;

import com.knackitsolutions.delhimetro.delhimetrobackend.client.StationClient;
import com.knackitsolutions.delhimetro.delhimetrobackend.dto.StationDTO;
import com.knackitsolutions.delhimetro.delhimetrobackend.service.StationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/stations")
@RequiredArgsConstructor
public class StationController {
    private final StationService stationsService;
    private final StationClient client;
    @GetMapping("/{start}")
    public ResponseEntity<List<StationDTO>> get(@PathVariable String start){
        List<StationDTO> list = stationsService.get(start);
        return ResponseEntity.ok(list);
    }
    @GetMapping
    public ResponseEntity<List<StationDTO>> getAll(){
        List<StationDTO> list = stationsService.getAll();
        return ResponseEntity.ok(list);
    }
}
