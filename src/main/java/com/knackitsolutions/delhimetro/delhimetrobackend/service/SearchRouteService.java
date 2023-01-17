package com.knackitsolutions.delhimetro.delhimetrobackend.service;

import com.knackitsolutions.delhimetro.delhimetrobackend.client.DelhiMetroClient;
import com.knackitsolutions.delhimetro.delhimetrobackend.dto.DelhiMetroRouteResponse;
import com.knackitsolutions.delhimetro.delhimetrobackend.dto.DelhiMetroRouteResponse.Path;
import com.knackitsolutions.delhimetro.delhimetrobackend.dto.DelhiMetroRouteResponse.Route;
import com.knackitsolutions.delhimetro.delhimetrobackend.entity.Station;
import com.knackitsolutions.delhimetro.delhimetrobackend.entity.StationInfo;
import com.knackitsolutions.delhimetro.delhimetrobackend.repository.StationInfoRepository;
import com.knackitsolutions.delhimetro.delhimetrobackend.repository.StationRepository;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SearchRouteService {

  private final DelhiMetroClient delhiMetroClient;
  private final StationInfoRepository stationInfoRepository;

  public DelhiMetroRouteResponse searchRoute(String fromStationCode, String toStationCode,
      String leavingTime) {
    DelhiMetroRouteResponse delhiMetroRouteResponse = delhiMetroClient.routeResponse(
        fromStationCode, toStationCode, leavingTime);
    for (Route route : delhiMetroRouteResponse.getRoute()) {
      updatePaths(route.getMapPath(), route.getPath());
    }
    return delhiMetroRouteResponse;
  }

  private void updatePaths(List<String> mapPath, List<Path> paths) {
    String lastPath = null;
    for (int i = 0; i < mapPath.size(); i++) {
      String[] split = mapPath.get(i).split("-");
      Path path = paths.get(i);
      updatePath(split[0], path);
      lastPath = split[split.length - 1];
    }
    updatePath(lastPath, paths.get(paths.size() - 1));
  }

  private void updatePath(String code, Path path) {
    Optional<StationInfo> byStationStationCodeLike = stationInfoRepository.findByStationStationCodeLike(
        code);
    byStationStationCodeLike.ifPresent(path::update);
  }

}
