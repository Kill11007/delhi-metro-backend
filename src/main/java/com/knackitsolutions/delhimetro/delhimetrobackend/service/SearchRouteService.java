package com.knackitsolutions.delhimetro.delhimetrobackend.service;

import com.knackitsolutions.delhimetro.delhimetrobackend.client.DelhiMetroClient;
import com.knackitsolutions.delhimetro.delhimetrobackend.dto.DelhiMetroRouteResponse;
import com.knackitsolutions.delhimetro.delhimetrobackend.dto.DelhiMetroRouteResponse.Path;
import com.knackitsolutions.delhimetro.delhimetrobackend.dto.DelhiMetroRouteResponse.Route;
import com.knackitsolutions.delhimetro.delhimetrobackend.entity.Station;
import com.knackitsolutions.delhimetro.delhimetrobackend.repository.StationRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SearchRouteService {

  private final DelhiMetroClient delhiMetroClient;
  private final StationRepository stationRepository;

  public DelhiMetroRouteResponse searchRoute(String fromStationCode, String toStationCode,
      String leavingTime) {
    DelhiMetroRouteResponse delhiMetroRouteResponse = delhiMetroClient.routeResponse(
        fromStationCode, toStationCode, leavingTime);
    for (Route route : delhiMetroRouteResponse.getRoute()) {
      for (Path path: route.getPath()) {
        List<Station> byStationNameLike = stationRepository.findByStationNameLike(path.getName());
        byStationNameLike.stream().findFirst().ifPresent(station -> path.update(station.getStationInfo()));
      }
    }
    return delhiMetroRouteResponse;
  }
}
