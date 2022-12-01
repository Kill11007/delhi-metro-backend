package com.knackitsolutions.delhimetro.delhimetrobackend.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.knackitsolutions.delhimetro.delhimetrobackend.dto.DelhiMetroRouteResponse;
import java.net.URI;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@Log4j2
@RequiredArgsConstructor
public class DelhiMetroClient {

  private final RestTemplate restTemplate;
  @Value("${delhimetro.route.url}")
  private String url;

  private final ObjectMapper objectMapper;

  public DelhiMetroRouteResponse routeResponse(String fromStationCode, String toStationCode,
      String leavingTime) {
    URI uri = UriComponentsBuilder.fromHttpUrl(url)
        .build(fromStationCode, toStationCode, leavingTime);
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.add("referer", "https://www.delhimetrorail.com/");
    HttpEntity<Object> entity = new HttpEntity<>(httpHeaders);
    ResponseEntity<DelhiMetroRouteResponse> forEntity = restTemplate.exchange(uri, HttpMethod.GET,
        entity, DelhiMetroRouteResponse.class);
    return forEntity.getBody();
  }

}
