package com.knackitsolutions.delhimetro.delhimetrobackend.controller;

import com.knackitsolutions.delhimetro.delhimetrobackend.client.DelhiMetroClient;
import com.knackitsolutions.delhimetro.delhimetrobackend.dto.DelhiMetroRouteResponse;
import com.knackitsolutions.delhimetro.delhimetrobackend.service.StationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/delhi-metro-backend")
@RequiredArgsConstructor
public class SearchRouteController {

  private final DelhiMetroClient client;
  private final StationService stationsService;

  @GetMapping("/route/{fromStation}/{toStation}/short-distance/{leavingTime}")
  public ResponseEntity<DelhiMetroRouteResponse> getRoute(@PathVariable String fromStation,
      @PathVariable String toStation, @PathVariable String leavingTime) {
    DelhiMetroRouteResponse delhiMetroRouteResponse = client.routeResponse(fromStation, toStation,
        leavingTime);
    return ResponseEntity.ok(delhiMetroRouteResponse);
  }

}
