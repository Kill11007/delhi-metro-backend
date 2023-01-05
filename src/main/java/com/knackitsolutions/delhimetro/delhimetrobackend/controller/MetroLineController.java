package com.knackitsolutions.delhimetro.delhimetrobackend.controller;

import com.knackitsolutions.delhimetro.delhimetrobackend.dto.DelhiMetroStationInfoResponse;
import com.knackitsolutions.delhimetro.delhimetrobackend.dto.MetroLineDTO;
import com.knackitsolutions.delhimetro.delhimetrobackend.service.MetroLineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/metro_line")
@RequiredArgsConstructor
public class MetroLineController {
    private final MetroLineService metroLineService;

}
